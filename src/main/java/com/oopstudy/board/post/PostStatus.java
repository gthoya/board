package com.oopstudy.board.post;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum PostStatus {
    TEMP("T", "임시저장"),
    PUBLISH("P", "발행");

    private String code;
    private String value;

    PostStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static PostStatus of(String code) {
        return Stream.of(PostStatus.values())
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
