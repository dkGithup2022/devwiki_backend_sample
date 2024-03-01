package com.dk0124.devwiki_core.article.dto;

public record TranslationArticleCreateDto(
        long authorId,
        String title,
        String content,
        boolean editable

) {

}
