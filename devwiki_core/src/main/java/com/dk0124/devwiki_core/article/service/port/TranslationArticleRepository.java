package com.dk0124.devwiki_core.article.service.port;

import com.dk0124.devwiki_core.article.model.TranslationArticleEntity;

import java.util.Optional;

public interface TranslationArticleRepository {

    TranslationArticleEntity save(TranslationArticleEntity entity);

    Optional<TranslationArticleEntity> findById(long id);

    long deleteById(long id);
}
