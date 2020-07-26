package com.oopstudy.board.post;

public enum PostStatus {
    TEMP("T"),
    PUBLISH("P"),
    DELETED("D");

    private String code;

    PostStatus(String code) {
        this.code = code;
    }
}
