package com.ohgiraffers.chap02.section02.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/* 괄호 - 백준(9012) */
class Practice1Test {

    private Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }


    static Stream<Arguments> provideTestCases(){
        return Stream.of(
                Arguments.arguments("(())())","NO"),
                Arguments.arguments("(((()())()","NO"),
                Arguments.arguments("(()())((()))","YES"),
                Arguments.arguments("((()()(()))(((())))()","NO"),
                Arguments.arguments("()()()()(()()())()","YES"),
                Arguments.arguments("(()((())()(","NO")
        );
    }

    @DisplayName("올바른 괄호 문자열 테스트")
    @ParameterizedTest // @Test 어노테이션의 한 종류, 파라미터 받아서 테스트 하겠다 선언.
    @MethodSource("provideTestCases") // 해당 데이터로 테스트 케이스 파라미터 전달 하겠다.
    void testParenthesisString(String input, String expected){
        String result = practice1.solution(input);
        Assertions.assertEquals(expected, result);
    }

}