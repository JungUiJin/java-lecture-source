package com.ohgiraffers.associationmapping.section01.manytoone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManyToOneServiceTest {
    @Autowired
    private ManyToOneService service;
    @Autowired
    private ManyToOneService manyToOneService;

    @DisplayName("N:1 연관관계 객체 그래프 탐색을 이용한 조회 테스트")
    @Test
    void manyToOneFindTest(){
        int menuCode=10;
        Menu foundMenu=service.findMenu(menuCode);
        Category category = foundMenu.getCategory();
        assertNotNull(category);
    }
    @DisplayName("N:1 연관관계 객체 지향 쿼리(jpql)을 이용한 조회 테스트")
    @Test
    void manyToOneJpqlTest(){
        int menuCode=9;
        String categoryName = service.findCategoryNameByJpql(menuCode);

        assertNotNull(categoryName);
        System.out.println("categoryName:"+categoryName);
    }

    private static Stream<Arguments> getMenuInfo(){
        return Stream.of(
                Arguments.of(123,"돈까스 스파게티", 30000, 123, "퓨전분식", "Y")
        );
    }

    @DisplayName("N:1 연관관계 객체 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getMenuInfo")
    void manyToOnensertTest(
            int menuCode, String menuName, int menuPrice,
            int categoryCode, String categoryName, String orderableStatus
    ){
        MenuDTO menu = new MenuDTO(
                menuCode,
                menuName,
                menuPrice,
                new CategoryDTO(
                        categoryCode,
                        categoryName,
                        null
                ),
                orderableStatus
        );
        assertDoesNotThrow(
                ()->manyToOneService.registMenu(menu)
        );
    }
}