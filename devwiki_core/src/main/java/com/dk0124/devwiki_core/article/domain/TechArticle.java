package com.dk0124.devwiki_core.article.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TechArticle {
    private final long articleId;

    private final Author author;

    private final String title;

    private final Content content;

    private final PopularityMetrics popularityMetrics;

    public void validate() {
        if (title == null || title.isBlank())
            throw new RuntimeException("this is bad title for article ");
        content.validate();
        author.validate();
        popularityMetrics.validate();
    }

    public TechArticle(long articleId, Author author, String title, Content content, PopularityMetrics popularityMetrics) {
        this.articleId = articleId;
        this.author = author;
        this.title = title;
        this.content = content;
        this.popularityMetrics = popularityMetrics;
    }
}
