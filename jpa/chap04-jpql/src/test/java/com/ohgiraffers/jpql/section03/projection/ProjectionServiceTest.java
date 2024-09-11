package com.ohgiraffers.jpql.section03.projection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectionServiceTest {

    @Autowired
    private ProjectionService projectionService;
    @Autowired
    private ProjectionRepository projectionRepository;

    @DisplayName("단일 엔터티 프로젝션")
    @Test
    void testSingleEntityProjection() {
        List<Menu> menus = projectionService.singleEntityProjection();
        assertNotNull(menus);
    }

    @DisplayName("임베디드 타입 프로젝션")
    @Test
    void testEmbeddedTypeProjection() {
        List<MenuInfo> menuInfos = projectionRepository.embeddedTypeProjection();
        assertNotNull(menuInfos);
    }

    @DisplayName("Query를 이용한 스칼라 타입 프로젝션 테스트")
    @Test
    public void testScalarTypeProjectionByQuery() {
        //given
        //when
        List<Object[]> categoryList = projectionRepository.scalarTypeProjection();

        //then
        Assertions.assertNotNull(categoryList);
        categoryList.forEach(
                row -> {
                    for(Object column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
        );
    }

    @DisplayName("스칼라 타입 프로젝션")
    @Test
    void testNewCommandProjection(){
        List<CategoryInfo> categoryInfos = projectionRepository.newCommandProjection();
        assertNotNull(categoryInfos);
        categoryInfos.forEach(System.out::println);
    }
}