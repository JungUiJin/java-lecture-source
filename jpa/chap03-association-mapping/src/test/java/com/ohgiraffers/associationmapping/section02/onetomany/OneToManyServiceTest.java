package com.ohgiraffers.associationmapping.section02.onetomany;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OneToManyServiceTest {

    @Autowired
    private OneToManyService service;

    @DisplayName("1:N 연관 관계 객체 그래프 탐색을 위한 조회")
    @Test
    void oneToManyFindTest(){
        int categoryCode = 4;
        Category category = service.findCategory(categoryCode);
        assertNotNull(category);
    }
}