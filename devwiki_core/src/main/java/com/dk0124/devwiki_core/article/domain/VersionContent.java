package com.dk0124.devwiki_core.article.domain;


import lombok.Builder;

@Builder
public record VersionContent(int version,
                             long articleId,
                             String versionTitle,
                             Author editor,
                             Content content,
                             PopularityMetrics versionPopularityMetrics) {
}
