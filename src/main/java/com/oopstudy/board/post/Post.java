package com.oopstudy.board.post;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Convert(converter = PostStatusConverter.class)
    private PostStatus postStatus;

    @Column
    private LocalDateTime createAt;

    @Column
    private Integer createUserSeq;

    @Column
    private LocalDateTime modifyAt;

    @Column
    private Integer modifyUserSeq;

    private Post(String title, String content, PostStatus postStatus) {
        this.title = title;
        this.content = content;
        this.postStatus = postStatus;
    }

    public Post(String title, String content, PostStatus postStatus, Integer createUserSeq) {
        this(title, content, postStatus);
        this.createAt = LocalDateTime.now();
        this.createUserSeq = createUserSeq;
    }

    public Post(Integer postSeq, String title, String content, PostStatus postStatus, LocalDateTime createAt, Integer createUserSeq, Integer modifyUserSeq) {
        this(title, content, postStatus);
        this.postSeq = postSeq;
        this.createAt = createAt;
        this.createUserSeq = createUserSeq;
        this.modifyAt = LocalDateTime.now();
        this.modifyUserSeq = modifyUserSeq;
    }
}
