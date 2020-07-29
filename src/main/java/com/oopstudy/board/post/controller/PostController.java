package com.oopstudy.board.post.controller;

import com.oopstudy.board.post.Post;
import com.oopstudy.board.post.PostStatus;
import com.oopstudy.board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Post createPost(String title, String content) {
        return postService.createPost(new Post(title, content, PostStatus.PUBLISH, 1));
    }
}
