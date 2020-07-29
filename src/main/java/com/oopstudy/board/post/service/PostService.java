package com.oopstudy.board.post.service;

import com.oopstudy.board.post.Post;
import com.oopstudy.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(Integer postSeq) {
        return postRepository.getOne(postSeq);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
