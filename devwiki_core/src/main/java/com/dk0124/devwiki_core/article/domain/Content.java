package com.dk0124.devwiki_core.article.domain;


import com.dk0124.devwiki_core.article.domain.strategy.ContentStrategy;
import lombok.Getter;

import java.util.List;

public record Content(List<ContentStrategy> contentStrategies, String content) {
    public Content newAndGet(String content) {
        return new Content(this.contentStrategies, content);
    }

    public void validate() {
        contentStrategies.stream()
                .forEach(strategy -> {
                    var pass = strategy.validateContent().test(this);
                    if (!pass)
                        throw new RuntimeException("CONTENT VALIDATION FAIL");
                });
    }


}
