package com.dk0124.devwiki_core.article.service;

import com.dk0124.devwiki_core.article.domain.*;
import com.dk0124.devwiki_core.article.domain.strategy.ContentLengthValidation;
import com.dk0124.devwiki_core.article.dto.TranslationArticleCreateDto;
import com.dk0124.devwiki_core.article.model.ArticleVersionContentEntity;
import com.dk0124.devwiki_core.article.model.TranslationArticleEntity;
import com.dk0124.devwiki_core.article.service.port.ArticleVersionContentRepository;
import com.dk0124.devwiki_core.article.service.port.AuthorRepository;
import com.dk0124.devwiki_core.article.service.port.TranslationArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@RequiredArgsConstructor
public class TranslationArticleService {

    private final TranslationArticleRepository translationArticleRepository;
    private final ArticleVersionContentRepository articleVersionContentRepository;
    private final AuthorRepository authorRepository;

    public long create(TranslationArticleCreateDto createDto) {
        if (!validateContent(createDto.content()))
            throw new RuntimeException("CONTENT VALIDATION");
        if (!validateTitle(createDto.title()))
            throw new RuntimeException("TITLE VALIDATION");

        // save meta data
        var translationArticle = TranslationArticleEntity.builder()
                .authorId(createDto.authorId())
                .initialTitle(createDto.title())
                .editable(createDto.editable()).build();

        var articleMetadata = translationArticleRepository.save(translationArticle);

        //save version data
        var versionContent = ArticleVersionContentEntity.builder()
                .content(createDto.content())
                .version(0)
                .versionTitle(createDto.title())
                .articleId(articleMetadata.getId())
                .editorId(createDto.authorId())
                .build();

        articleVersionContentRepository.save(versionContent);

        return articleMetadata.getId();
    }

    public TranslationArticle read(long articleId, int version) {
        var versionContent = articleVersionContentRepository.findByArticleIdAndVersion(articleId, version)
                .orElseThrow(RuntimeException::new);

        var articleMeta = translationArticleRepository.findById(articleId)
                .orElseThrow(RuntimeException::new);

        var author = authorRepository.getAuthor(articleMeta.getAuthorId());

        var editor = authorRepository.getAuthor(versionContent.getEditorId());

        return  TranslationArticle.builder()
                .articleId(articleMeta.getId())
                .initialTitle(articleMeta.getInitialTitle())
                .editable(articleMeta.getEditable())
                .author(author)
                .totalPopularityMetrics(
                        PopularityMetrics.builder()
                                .views(articleMeta.getViews())
                                .likes(articleMeta.getLikes())
                                .dislikes(articleMeta.getDislikes())
                                .comments(articleMeta.getComments())
                                .build()
                ).versionContent(
                        VersionContent.builder()
                                .articleId(versionContent.getArticleId())
                                .content(new Content(List.of(new ContentLengthValidation()) ,versionContent.getContent()))
                                .version(versionContent.getVersion())
                                .versionTitle(versionContent.getVersionTitle())
                                .editor(editor)
                                .versionPopularityMetrics(
                                        PopularityMetrics.builder()
                                                .views(versionContent.getViews())
                                                .likes(versionContent.getLikes())
                                                .dislikes(versionContent.getDislikes())
                                                .comments(versionContent.getComments())
                                                .build()
                                )
                                .build()
                ).build();
    }

    /*
    public long update(TranslationArticleUpdateDto updateDto){
        // TODO : this operation needs lock for generation of version .
        return 0L;
    }
     */


    private boolean validateTitle(String title) {
        if (title == null || title.isEmpty())
            return false;

        return true;
    }

    private boolean validateContent(String content) {
        // Content 로직의 validation 이 수행 가능한지 확인, update 때문에 Boolean 으로 가져옴 .
        var contentWithStrategy = articleContent(content);
        AtomicBoolean canBeUpdated = new AtomicBoolean(true);
        contentWithStrategy.contentStrategies()
                .stream().forEach(contentStrategy
                        -> canBeUpdated.set(canBeUpdated.get() & contentStrategy.validateContent().test(contentWithStrategy)));
        return canBeUpdated.get();
    }

    private Content articleContent(String content) {
        return new Content(
                List.of(new ContentLengthValidation()),
                content
        );
    }
}
