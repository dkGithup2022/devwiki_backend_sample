package com.dk0124.devwiki_core.article.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticleVersionContentEntity is a Querydsl query type for ArticleVersionContentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleVersionContentEntity extends EntityPathBase<ArticleVersionContentEntity> {

    private static final long serialVersionUID = 265680351L;

    public static final QArticleVersionContentEntity articleVersionContentEntity = new QArticleVersionContentEntity("articleVersionContentEntity");

    public final NumberPath<Long> articleId = createNumber("articleId", Long.class);

    public final NumberPath<Long> comments = createNumber("comments", Long.class);

    public final StringPath content = createString("content");

    public final NumberPath<Long> dislikes = createNumber("dislikes", Long.class);

    public final NumberPath<Long> editorId = createNumber("editorId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> likes = createNumber("likes", Long.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public final StringPath versionTitle = createString("versionTitle");

    public final NumberPath<Long> views = createNumber("views", Long.class);

    public QArticleVersionContentEntity(String variable) {
        super(ArticleVersionContentEntity.class, forVariable(variable));
    }

    public QArticleVersionContentEntity(Path<? extends ArticleVersionContentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleVersionContentEntity(PathMetadata metadata) {
        super(ArticleVersionContentEntity.class, metadata);
    }

}

