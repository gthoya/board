package com.oopstudy.board.test.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
}
