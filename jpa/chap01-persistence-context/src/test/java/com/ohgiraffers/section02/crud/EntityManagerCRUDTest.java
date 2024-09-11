package com.ohgiraffers.section02.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerCRUDTest {
    private EntityManagerCRUD entityManagerCRUD;

    @BeforeEach
    void init(){
        this.entityManagerCRUD = new EntityManagerCRUD();
    }

    @DisplayName("메뉴 코드로 메뉴 조회")
    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,3"}) // CSV(Comma Separated Values 는 콤마 기준으로 구분
    void testFindMethodByMenuCode(int menuCode, int expected){
        // when
        Menu foundMenu = entityManagerCRUD.findMenuByMenuCode(menuCode);

        // then
        assertEquals(expected, foundMenu.getMenuCode());
        System.out.println("foundMenu = " + foundMenu);
    }

    private static Stream<Arguments> newMenu(){
        return Stream.of(
                Arguments.of(
                        "신메뉴",
                        35000,
                        4,
                        "Y"
                )
        );
    }

    @DisplayName("메뉴 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testRegistMenu(String menuName, int menuPrice, int categoryCode, String orderableStatus){

        // when
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long count = entityManagerCRUD.saveAndReturnAllCount(menu);

        // then
        assertEquals(23, count);
    }

    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("1, 변경 된 이름")
    void testModifyMenuName(int menuCode, String newMenuName){
        // when
        Menu menu = entityManagerCRUD.modifyMenuName(menuCode, newMenuName);
        assertEquals(newMenuName, menu.getMenuName());
    }

    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testRemoveMenu(int menuCode){
        // when
        Long count = entityManagerCRUD.removeAndReturnAllCount(menuCode);
        assertEquals(22, count);
    }
}