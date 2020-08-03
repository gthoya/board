package com.oopstudy.board.post.controller;

import com.oopstudy.board.post.Post;
import com.oopstudy.board.post.PostStatus;
import com.oopstudy.board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post/{postSeq}")
    public String getPost(Model model, @PathVariable Integer postSeq) {
        Post post = postService.getPost(postSeq);
        if (post == null) {
            post = new Post();
        }

        model.addAttribute(post);
        return "post/post";
    }

    @PostMapping("/post")
    @ResponseBody
    public Post createPost(String title, String content, String postStatus) {
        return postService.createPost(new Post(title, content, PostStatus.of(postStatus), 1));
    }

    @PutMapping("/post/{postSeq}")
    @ResponseBody
    public Post modifyPost(@PathVariable Integer postSeq, String title, String content, String postStatus, @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createAt) {
        return postService.createPost(new Post(postSeq, title, content, PostStatus.of(postStatus), createAt, 1, 1));
    }

    @DeleteMapping("/post/{postSeq}")
    @ResponseBody
    public String removePost(@PathVariable Integer postSeq) {
        try {
            postService.removePost(postSeq);
        } catch (IllegalArgumentException e) {
            return "argument is not valid";
        } catch (EmptyResultDataAccessException e) {
            return "data is not found";
        }

        return "success";
    }
}
