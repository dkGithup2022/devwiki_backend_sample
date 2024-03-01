package com.dk0124.devwiki_core.article.dto;

public record TechArticleUpdateDto(
        long articleId
        , String title,
        String content) {
}
