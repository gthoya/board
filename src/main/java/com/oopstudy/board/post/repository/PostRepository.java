package com.oopstudy.board.post.repository;

import com.oopstudy.board.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
