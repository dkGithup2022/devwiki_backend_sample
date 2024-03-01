package com.dk0124.devwiki_core.article.domain;

import lombok.Builder;

@Builder
public record TranslationArticle(long articleId,
                                 Author author,

                                 String initialTitle,
                                 boolean editable,
                                 PopularityMetrics totalPopularityMetrics,
                                 VersionContent versionContent
                                 ) {


}
