package com.ohgiraffers.chap02.section03.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Practice1Test {

    private Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }

    static Stream<Arguments> provideTestCases(){
        return Stream.of(
                Arguments.arguments(7, 3, "<3, 6, 2, 7, 5, 1, 4>"),
                Arguments.arguments(5, 2, "<2, 4, 1, 5, 3>")
        );
    }

    @DisplayName("요세푸스 테스트")
    @ParameterizedTest // @Test 어노테이션의 한 종류, 파라미터 받아서 테스트 하겠다 선언.
    @MethodSource("provideTestCases") // 해당 데이터로 테스트 케이스 파라미터 전달 하겠다.
    void testSolution(int i, int k, String expected){
        String result = practice1.solution(i, k);
        Assertions.assertEquals(expected, result);
    }

}