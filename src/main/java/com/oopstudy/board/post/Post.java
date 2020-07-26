package com.oopstudy.board.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
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
}
