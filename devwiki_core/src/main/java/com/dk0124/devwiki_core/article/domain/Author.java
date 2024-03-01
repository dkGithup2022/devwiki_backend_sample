package com.dk0124.devwiki_core.article.domain;


import lombok.Builder;
import lombok.Getter;

@Builder
public record Author(long authorId, String nickname, String userGithubProfile) {

    public void validate(){

    }

}
