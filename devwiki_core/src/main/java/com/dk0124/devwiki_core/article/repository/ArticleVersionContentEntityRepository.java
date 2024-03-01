package com.dk0124.devwiki_core.article.repository;

import com.dk0124.devwiki_core.article.model.ArticleVersionContentEntity;
import com.dk0124.devwiki_core.article.service.port.ArticleVersionContentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleVersionContentEntityRepository extends JpaRepository<ArticleVersionContentEntity, Long>, ArticleVersionContentRepository {

    Optional<ArticleVersionContentEntity> findByArticleIdAndVersion(long articleId, int version);
}
