package com.oopstudy.board.test.controller;

import com.oopstudy.board.test.dao.TestJpaRepository;
import com.oopstudy.board.test.dao.TestMybatisDao;
import com.oopstudy.board.test.entity.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {
    private final TestJpaRepository testJpaRepository;
    private final TestMybatisDao testMybatisDao;

    @GetMapping("/test")
    @ResponseBody
    public List<Test> testAll() {
        return testJpaRepository.findAll();
    }

    @GetMapping("/test/jpa/{id}")
    @ResponseBody
    public Test testJpa(@PathVariable Integer id) {
        Optional<Test> optionalTest = testJpaRepository.findById(id);
        if (!optionalTest.isPresent()) {
            return new Test();
        }

        Test test = optionalTest.get();
        log.info("{}", test);

        return test;
    }

    @GetMapping("/test/mybatis/{id}")
    @ResponseBody
    public Test testMybatis(@PathVariable Integer id) {
       return testMybatisDao.selectTest(id);
    }

    @GetMapping("/test/thymeleaf/{id}")
    public String testThymelaf(Model model, @PathVariable Integer id) {
        model.addAttribute(this.testJpa(id));
        return "test";
    }
}
