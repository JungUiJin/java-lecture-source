package com.ohgiraffers.jpql.section06.join;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JoinRepositoryTest {

    @Autowired
    JoinRepository joinRepository;

    @DisplayName("내부 조인 테스트")
    @Test
    void testSelectByInnerJoin(){
    //given
        //when
        List<Menu> menuList = joinRepository.selectByInnerJoin();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

    @DisplayName("페치조인을 이용한 조회 테스트")
    @Test
    public void testSelectByFetchJoin() {
        //given
        //when
        List<Menu> menuList = joinRepository.selectByFetchJoin();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

    @DisplayName("외부조인을 이용한 조회 테스트")
    @Test
    public void testSelectByOuterJoin() {
        //given
        //when
        List<Object[]> menuList = joinRepository.selectByOuterJoin();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
        );
    }

    @DisplayName("컬렉션을 이용한 조회 테스트")
    @Test
    public void testSelectByCollectionJoin() {
        //given
        //when
        List<Object[]> menuList = joinRepository.selectByCollectionJoin();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
        );
    }
    @DisplayName("컬렉션을 이용한 조회 테스트")
    @Test
    public void testSelectByThetaJoin() {
        //given
        //when
        List<Object[]> menuList = joinRepository.selectByThetaJoin();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
        );
    }

}