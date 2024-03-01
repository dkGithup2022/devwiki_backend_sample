package com.dk0124.devwiki_core.article.dto;

public record TechArticleCreateDto(
        long authorId,
        String title,
        String content
) {
}
