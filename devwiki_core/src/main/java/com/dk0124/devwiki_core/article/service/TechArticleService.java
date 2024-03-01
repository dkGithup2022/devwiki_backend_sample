package com.dk0124.devwiki_core.article.service;

import com.dk0124.devwiki_core.article.domain.Content;
import com.dk0124.devwiki_core.article.domain.PopularityMetrics;
import com.dk0124.devwiki_core.article.domain.TechArticle;
import com.dk0124.devwiki_core.article.domain.strategy.ContentLengthValidation;
import com.dk0124.devwiki_core.article.dto.TechArticleCreateDto;
import com.dk0124.devwiki_core.article.dto.TechArticleUpdateDto;
import com.dk0124.devwiki_core.article.model.TechArticleEntity;
import com.dk0124.devwiki_core.article.service.port.AuthorRepository;
import com.dk0124.devwiki_core.article.service.port.TechArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@RequiredArgsConstructor
public class TechArticleService {

    private final TechArticleRepository techArticleRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public TechArticle read(long articleId) {

        var entity = techArticleRepository.findById(articleId)
                .orElseThrow(RuntimeException::new);

        var author = authorRepository.getAuthor(entity.getAuthorId());

        var popularity = PopularityMetrics.builder()
                .views(entity.getViews())
                .likes(entity.getLikes())
                .dislikes(entity.getDislikes())
                .comments(entity.getComments()).build();

        return TechArticle.builder()
                .title(entity.getTitle())
                .content(techArticleContent(entity.getContent()))
                .author(author)
                .articleId(entity.getId())
                .popularityMetrics(popularity)
                .build();
    }

    @Transactional
    public long update(TechArticleUpdateDto updateDto) {
        var entity = techArticleRepository.findById(updateDto.articleId())
                .orElseThrow(RuntimeException::new);

        if (validateTitle(updateDto.title()))
            entity.setTitle(updateDto.title());

        if (validateContent(updateDto.content()))
            entity.setContent(updateDto.content());

        return entity.getId();
    }

    @Transactional
    public void delete(long articleId) {
        techArticleRepository.deleteById(articleId);
    }

    @Transactional
    public long create(TechArticleCreateDto createDto) {

        if (!validateContent(createDto.content()))
            throw new RuntimeException("CONTENT VALIDATION");
        if (!validateTitle(createDto.title()))
            throw new RuntimeException("TITLE VALIDATION");

        var saved = techArticleRepository.save(
                TechArticleEntity.builder()
                        .authorId(createDto.authorId())
                        .title(createDto.title())
                        .content(createDto.content())
                        .build()
        );
        return saved.getId();
    }

    private Content techArticleContent(String content) {
        return new Content(
                List.of(new ContentLengthValidation()),
                content
        );
    }

    private boolean validateTitle(String title) {
        if (title == null || title.isEmpty())
            return false;

        return true;
    }

    private boolean validateContent(String content) {
        // Content 로직의 validation 이 수행 가능한지 확인, update 때문에 Boolean 으로 가져옴 .
        var contentWithStrategy = techArticleContent(content);
        AtomicBoolean canBeUpdated = new AtomicBoolean(true);
        contentWithStrategy.contentStrategies()
                .stream().forEach(contentStrategy
                        -> canBeUpdated.set(canBeUpdated.get() & contentStrategy.validateContent().test(contentWithStrategy)));
        return canBeUpdated.get();
    }
}
