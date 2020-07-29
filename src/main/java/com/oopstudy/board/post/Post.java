package com.oopstudy.board.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postSeq;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private PostStatus postStatus;

    @Column
    private LocalDateTime createAt;

    @Column
    private Integer createUserSeq;

    @Column
    private LocalDateTime modifyAt;

    @Column
    private Integer modifyUserSeq;

    public Post(String title, String content, PostStatus postStatus, Integer createUserSeq) {
        this.title = title;
        this.content = content;
        this.postStatus = postStatus;
        this.createAt = LocalDateTime.now();
        this.createUserSeq = createUserSeq;
    }
}
