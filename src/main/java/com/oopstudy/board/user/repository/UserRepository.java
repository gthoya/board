package com.oopstudy.board.user.repository;

import com.oopstudy.board.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(final User user);
}
