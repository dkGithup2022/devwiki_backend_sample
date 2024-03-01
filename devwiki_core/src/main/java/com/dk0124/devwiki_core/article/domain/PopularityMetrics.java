package com.dk0124.devwiki_core.article.domain;

import lombok.Builder;

@Builder
public record PopularityMetrics(long likes, long dislikes, long comments, long views) {
    public void validate(){

    }
}
