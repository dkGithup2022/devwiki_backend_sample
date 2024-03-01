package com.dk0124.devwiki_core.article.domain.strategy;

import com.dk0124.devwiki_core.article.domain.Content;

import java.util.function.Function;
import java.util.function.Predicate;

public interface ContentStrategy {
    Predicate<Content> validateContent();
}
