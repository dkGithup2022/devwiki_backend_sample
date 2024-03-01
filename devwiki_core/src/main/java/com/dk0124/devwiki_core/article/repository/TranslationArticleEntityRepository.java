package com.dk0124.devwiki_core.article.repository;

import com.dk0124.devwiki_core.article.model.TranslationArticleEntity;
import com.dk0124.devwiki_core.article.service.port.TranslationArticleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationArticleEntityRepository extends JpaRepository<TranslationArticleEntity,Long> , TranslationArticleRepository {
}
