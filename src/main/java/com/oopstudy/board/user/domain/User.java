package com.oopstudy.board.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oopstudy.board.user.domain.password.Password;

public class User {
    private final Email email;

    @JsonIgnore
    private final Password password;

    private final Phone phone;

    public User(final Email email, final Password password, final Phone phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public Phone getPhone() {
        return phone;
    }
}
