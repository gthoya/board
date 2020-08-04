package com.oopstudy.board.user.repository;

import com.oopstudy.board.user.domain.User;

public interface UserRepository {
    User save(final User user);
}
