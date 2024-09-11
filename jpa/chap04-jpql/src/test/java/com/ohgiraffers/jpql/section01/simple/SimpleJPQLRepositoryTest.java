package com.ohgiraffers.jpql.section01.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleJPQLRepositoryTest {

    @Autowired
    SimpleJPQLRepository simpleJPQLRepository;

    @DisplayName("TypedQuery를 이용한 단일행, 단일 컬럼 조회")
    @Test
    void testSelectSingleMenuByTypedQuery(){
        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();
        assertEquals(menuName, "우럭스무디");
    }
    @DisplayName("Query를 이용한 단일행, 단일 컬럼 조회")
    @Test
    void testSelectSingleMenuByQuery(){
        Object menuName = simpleJPQLRepository.selectSingleMenuByQuery();
        assertEquals(menuName, "우럭스무디");
    }

    @DisplayName("TypedQuery를 이용한 단일행 조회")
    @Test
    void testSelectSingleRowByTypedQuery(){
        Menu menu = simpleJPQLRepository.selectSingleRowByTypedQuery();
        assertEquals("우럭스무디",menu.getMenuName());
    }
    @DisplayName("TypedQuery를 이용한 다중행 조회")
    @Test
    void testSelectMultipleRowByTypedQuery(){
        List<Menu> menu = simpleJPQLRepository.selectMultipleRowByTypedQuery();
        assertNotNull(menu);
    }
    @DisplayName("Distinct를 이용한 다중행 조회")
    @Test
    void testSelectUsingDistinct(){
        List<Integer> categoryList = simpleJPQLRepository.selectUsingDistinct();
        System.out.println("categoryList: " + categoryList);
        assertNotNull(categoryList);
    }
    @DisplayName("IN를 이용한 다중행 조회")
    @Test
    void testSelectUsingIN(){
        List<Menu> categoryList = simpleJPQLRepository.selectUsingIn();
        System.out.println("카테고리 4, 5, 6: " + categoryList);
        assertNotNull(categoryList);
    }
    @DisplayName("LIKE를 이용한 다중행 조회")
    @Test
    void testSelectUsingLike(){
        List<Menu> menuList = simpleJPQLRepository.selectUsingLike();
        System.out.println("김치 들어가는거 : " + menuList);
        assertNotNull(menuList);
    }
}