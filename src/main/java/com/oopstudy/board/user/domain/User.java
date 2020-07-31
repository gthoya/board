package com.oopstudy.board.user.domain;

import java.util.Objects;

public class User {
    private final Email email;

    /*@JsonIgnore
    private String password;*/

    public User(final Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
