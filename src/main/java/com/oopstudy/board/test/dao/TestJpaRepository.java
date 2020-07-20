package com.oopstudy.board.test.dao;

import com.oopstudy.board.test.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJpaRepository extends JpaRepository<Test, Integer> {
}
