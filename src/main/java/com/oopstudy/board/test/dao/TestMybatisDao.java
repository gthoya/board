package com.oopstudy.board.test.dao;

import com.oopstudy.board.test.entity.Test;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestMybatisDao {
    private final String namespace = "com.oopstudy.board.test.";

    private final SqlSession sqlSession;

    public Test selectTest(Integer id) {
        return sqlSession.selectOne(namespace + "selectTest", id);
    }
}
