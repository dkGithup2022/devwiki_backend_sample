package com.dk0124.devwiki_api.controller;

import com.dk0124.devwiki_core.article.domain.TechArticle;
import com.dk0124.devwiki_core.article.dto.TechArticleCreateDto;
import com.dk0124.devwiki_core.article.service.TechArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/article")
@RequiredArgsConstructor
public class ArticleController {


    private final TechArticleService techArticleService;

    @GetMapping("/tech")
    public ResponseEntity<TechArticle> getTechArticle(@RequestParam long id) {
        var article = techArticleService.read(id);
        return ResponseEntity.ok(article);
    }

    @PostMapping("/tech")
    public ResponseEntity<Long> createTechArticle(@RequestBody TechArticleCreateDto createDto) {
        var articleId = techArticleService.create(createDto);
        return ResponseEntity.ok(articleId);
    }


}
