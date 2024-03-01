package com.dk0124.devwiki_core.article.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTranslationArticleEntity is a Querydsl query type for TranslationArticleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTranslationArticleEntity extends EntityPathBase<TranslationArticleEntity> {

    private static final long serialVersionUID = 1073881955L;

    public static final QTranslationArticleEntity translationArticleEntity = new QTranslationArticleEntity("translationArticleEntity");

    public final NumberPath<Long> authorId = createNumber("authorId", Long.class);

    public final NumberPath<Long> comments = createNumber("comments", Long.class);

    public final NumberPath<Long> dislikes = createNumber("dislikes", Long.class);

    public final BooleanPath editable = createBoolean("editable");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath initialTitle = createString("initialTitle");

    public final NumberPath<Long> likes = createNumber("likes", Long.class);

    public final NumberPath<Long> views = createNumber("views", Long.class);

    public QTranslationArticleEntity(String variable) {
        super(TranslationArticleEntity.class, forVariable(variable));
    }

    public QTranslationArticleEntity(Path<? extends TranslationArticleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTranslationArticleEntity(PathMetadata metadata) {
        super(TranslationArticleEntity.class, metadata);
    }

}

