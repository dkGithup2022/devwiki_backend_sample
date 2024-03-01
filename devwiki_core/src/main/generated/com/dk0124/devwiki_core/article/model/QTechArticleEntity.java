package com.dk0124.devwiki_core.article.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTechArticleEntity is a Querydsl query type for TechArticleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTechArticleEntity extends EntityPathBase<TechArticleEntity> {

    private static final long serialVersionUID = 849773512L;

    public static final QTechArticleEntity techArticleEntity = new QTechArticleEntity("techArticleEntity");

    public final NumberPath<Long> authorId = createNumber("authorId", Long.class);

    public final NumberPath<Long> comments = createNumber("comments", Long.class);

    public final StringPath content = createString("content");

    public final NumberPath<Long> dislikes = createNumber("dislikes", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> likes = createNumber("likes", Long.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> views = createNumber("views", Long.class);

    public QTechArticleEntity(String variable) {
        super(TechArticleEntity.class, forVariable(variable));
    }

    public QTechArticleEntity(Path<? extends TechArticleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTechArticleEntity(PathMetadata metadata) {
        super(TechArticleEntity.class, metadata);
    }

}

