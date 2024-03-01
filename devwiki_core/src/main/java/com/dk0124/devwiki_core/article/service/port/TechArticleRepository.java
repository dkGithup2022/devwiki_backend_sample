package com.dk0124.devwiki_core.article.service.port;

import com.dk0124.devwiki_core.article.model.TechArticleEntity;

import java.util.Optional;

public interface TechArticleRepository {

    Optional<TechArticleEntity> findById(long id);

    TechArticleEntity save(TechArticleEntity techArticleEntity);

    long deleteById(long id);
}
