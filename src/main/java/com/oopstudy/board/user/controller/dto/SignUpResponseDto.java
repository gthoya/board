package com.oopstudy.board.user.controller.dto;

import com.oopstudy.board.user.domain.User;

public class SignUpResponseDto {
    private final User user;

    public SignUpResponseDto(final User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
