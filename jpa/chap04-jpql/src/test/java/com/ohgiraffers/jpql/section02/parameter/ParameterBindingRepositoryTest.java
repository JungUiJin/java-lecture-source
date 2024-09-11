package com.ohgiraffers.jpql.section02.parameter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParameterBindingRepositoryTest {

    @Autowired
    private ParameterBindingRepository repository;

    @DisplayName("이름 기준 파라미터 바인딩 테스트")
    @Test
    void testParameterBindingByName(){
        String menuName = "우럭스무디";
        List<Menu> menus = repository.selectMenuByBindingName(menuName);
        assertEquals(menuName, menus.get(0).getMenuName());
    }
    @DisplayName("위치 기준 파라미터 바인딩 테스트")
    @Test
    void testParameterBindingByPosition(){
        String menuName = "우럭스무디";
        List<Menu> menus = repository.selectMenuByBindingPosition(menuName);
        assertEquals(menuName, menus.get(0).getMenuName());
    }
}