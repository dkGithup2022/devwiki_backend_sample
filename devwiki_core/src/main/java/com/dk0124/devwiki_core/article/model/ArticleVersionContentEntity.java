package com.dk0124.devwiki_core.article.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ArticleVersionContentEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long articleId;

    private Long editorId;

    private int version;

    @Column(nullable = false, length = 1024)
    @Setter
    private String versionTitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Setter
    private String content;

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
