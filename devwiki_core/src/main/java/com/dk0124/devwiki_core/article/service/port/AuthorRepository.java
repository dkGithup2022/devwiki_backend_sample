package com.dk0124.devwiki_core.article.service.port;

import com.dk0124.devwiki_core.article.domain.Author;
import org.springframework.stereotype.Repository;


/*
* 테스트 용도
* */
@Repository
public class AuthorRepository {
    public Author getAuthor(long userId){
        return Author.builder()
                .authorId(1L)
                .nickname("TEST USER")
                .userGithubProfile("TEST GITHUB PROFILE")
                .build();
    }
}
