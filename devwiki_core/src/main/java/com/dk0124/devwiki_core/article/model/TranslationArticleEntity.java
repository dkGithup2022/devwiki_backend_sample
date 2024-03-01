package com.dk0124.devwiki_core.article.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TranslationArticleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long authorId;

    @Column(nullable = false, length = 1024)
    @Setter
    private String initialTitle;


    @Builder.Default
    @Column(nullable = false)
    private Boolean editable = true;

    @Builder.Default
    @Column(nullable = false)
    private Long likes = 0L;

    @Builder.Default
    @Column(nullable = false)
    private Long dislikes = 0L;

    @Builder.Default
    @Column(nullable = false)
    private Long views = 0L;

    @Builder.Default
    @Column(nullable = false)
    private Long comments = 0L;

}
