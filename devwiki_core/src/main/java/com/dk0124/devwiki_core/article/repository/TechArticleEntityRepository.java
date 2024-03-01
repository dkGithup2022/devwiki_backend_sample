package com.dk0124.devwiki_core.article.repository;

import com.dk0124.devwiki_core.article.model.TechArticleEntity;
import com.dk0124.devwiki_core.article.service.port.TechArticleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TechArticleEntityRepository extends JpaRepository<TechArticleEntity, Long >, TechArticleRepository {
}
