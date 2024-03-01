package com.dk0124.devwiki_core.article.service;

import com.dk0124.devwiki_core.IntegrationTest;
import com.dk0124.devwiki_core.article.dto.TranslationArticleCreateDto;
import com.dk0124.devwiki_core.article.service.port.ArticleVersionContentRepository;
import com.dk0124.devwiki_core.article.service.port.TranslationArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
class TranslationArticleServiceTest extends IntegrationTest {

    @Autowired
    private TranslationArticleRepository translationArticleRepository;

    @Autowired
    private ArticleVersionContentRepository articleVersionContentRepository;

    @Autowired
    private TranslationArticleService translationArticleService;

    private static final Long AUTHOR_ID = 1L;

    private static int INITIAL_VERSION = 0;
    private static final String TITLE = "TITLE";
    private static final String CONTENT = "CONTENT";

    private static final String VERSION_TITLE = "VERSION_TITLE";
    private static final String VERSION_CONTENT = "VERSION_CONTENT";


    @Test
    @DisplayName("create 성공 ")
    void create_1() {
        var req = new TranslationArticleCreateDto(AUTHOR_ID, TITLE, CONTENT, true);
        var id = translationArticleService.create(req);

        var articleEntity = translationArticleRepository.findById(id).get();
        var versionContent = articleVersionContentRepository.findByArticleIdAndVersion(id, INITIAL_VERSION).get();

        assertEquals(TITLE, articleEntity.getInitialTitle());
        assertEquals(AUTHOR_ID, articleEntity.getAuthorId());
        assertEquals(true, articleEntity.getEditable());
        assertEquals(0L, articleEntity.getLikes());
        assertEquals(0L, articleEntity.getDislikes());
        assertEquals(0L, articleEntity.getComments());
        assertEquals(0L, articleEntity.getViews());


        assertEquals(CONTENT, versionContent.getContent());
        assertEquals(articleEntity.getId(), versionContent.getArticleId());
        assertEquals(AUTHOR_ID, versionContent.getEditorId());
        assertEquals(INITIAL_VERSION, versionContent.getVersion());
        assertEquals(TITLE, versionContent.getVersionTitle());
        assertEquals(0L, versionContent.getLikes());
        assertEquals(0L, versionContent.getDislikes());
        assertEquals(0L, versionContent.getComments());
        assertEquals(0L, versionContent.getViews());
    }

    @Test
    @DisplayName("create 실패: 아주 긴 컨텐츠  ")
    void create_2() {
        var badContent = "*".repeat(1024*1024*10+1);
        var req = new TranslationArticleCreateDto(AUTHOR_ID, TITLE, badContent, true);
        assertThrows(RuntimeException.class, ()-> translationArticleService.create(req));
    }

    @Test
    @DisplayName("read  성공")
    void read_1() {


    }

    @Test
    @DisplayName("read 실패: 없는 버전 ")
    void read_2() {

    }

    @Test
    @DisplayName("read 실패: 없는 아티클 ")
    void read_3() {

    }


}