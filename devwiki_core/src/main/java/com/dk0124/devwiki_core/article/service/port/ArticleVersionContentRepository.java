package com.dk0124.devwiki_core.article.service.port;

import com.dk0124.devwiki_core.article.model.ArticleVersionContentEntity;

import java.util.Optional;

public interface ArticleVersionContentRepository {

    Optional<ArticleVersionContentEntity> findByArticleIdAndVersion(long articleId, int version);
    ArticleVersionContentEntity save(ArticleVersionContentEntity entity);

    Optional<ArticleVersionContentEntity> findById(long id);

    long deleteById(long id);
}
