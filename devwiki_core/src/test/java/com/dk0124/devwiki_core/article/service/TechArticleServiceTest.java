package com.dk0124.devwiki_core.article.service;

import com.dk0124.devwiki_core.IntegrationTest;
import com.dk0124.devwiki_core.article.dto.TechArticleCreateDto;
import com.dk0124.devwiki_core.article.dto.TechArticleUpdateDto;
import com.dk0124.devwiki_core.article.model.TechArticleEntity;
import com.dk0124.devwiki_core.article.service.port.TechArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
class TechArticleServiceTest extends IntegrationTest {

    @Autowired
    private TechArticleService techArticleService;
    @Autowired
    private TechArticleRepository techArticleRepository;

    private static final String TITLE = "TITLE";
    private static final String CONTENT = "CONTENT";


    @Test
    @DisplayName("생성 성공: 정상적으로 생성됨 .")
    void create_1() {
        var req = new TechArticleCreateDto(1L, "title", "content");
        var saved = techArticleService.create(req);

        var found = techArticleRepository.findById(saved).get();

        assertEquals(req.authorId(), found.getAuthorId());
        assertEquals(req.content(), found.getContent());
        assertEquals(req.title(), found.getTitle());
        assertEquals(0L, found.getComments());
        assertEquals(0L, found.getLikes());
        assertEquals(0L, found.getDislikes());
        assertEquals(0L, found.getViews());
    }

    @Test
    @DisplayName("생성 실패: 너무 긴 타이틀 .")
    void create_2() {

    }

    @Test
    @DisplayName("생성 실패: 너무 긴 컨텐츠 .")
    void create_3() {

    }

    @Test
    @DisplayName("update 성공")
    void update_1() {
        var articleId = saveOne();
        var updatedTitle = "TITLE CHANGED";
        var updatedContent = "CONTENT UPDATED";
        var req = new TechArticleUpdateDto(articleId, updatedTitle, updatedContent);

        techArticleService.update(req);

        var updated = techArticleRepository.findById(articleId).get();

        assertEquals(updatedTitle, updated.getTitle());
        assertEquals(updatedContent, updated.getContent());
    }

    @Test
    @DisplayName("조회 성공")
    void read_1() {
        var articleId = saveOne();
        var found = techArticleService.read(articleId);

        assertEquals(articleId, found.getArticleId());
        assertEquals(TITLE, found.getTitle());
        //title
        assertNotNull(found.getContent());
        assertEquals(CONTENT, found.getContent().content());
        // 인기 지표
        assertNotNull(found.getPopularityMetrics());
        assertEquals(0, found.getPopularityMetrics().comments());
        assertEquals(0, found.getPopularityMetrics().likes());
        assertEquals(0, found.getPopularityMetrics().dislikes());
        assertEquals(0, found.getPopularityMetrics().views());

        // author
        assertNotNull(found.getAuthor());
    }

    long saveOne() {
        return techArticleRepository.save(
                TechArticleEntity.builder()
                        .authorId(1L)
                        .title(TITLE)
                        .content(CONTENT)
                        .build()
        ).getId();
    }


}