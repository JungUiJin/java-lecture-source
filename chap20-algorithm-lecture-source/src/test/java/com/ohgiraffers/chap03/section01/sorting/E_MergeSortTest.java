package com.ohgiraffers.chap03.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class E_MergeSortTest {
    static int[] act1, act2, exp1, exp2;
    @BeforeAll
    static void setUp(){
        act1 = new int[]{34, 23, 24, 5, 1, 31, 12, 29, 9};
        act2 = new int[]{40, 47, 38, 8, 35, 33, 1, 5};
        exp1 = new int[]{1, 5, 9, 12, 23, 24, 29, 31, 34};
        exp2 = new int[]{1, 5, 8, 33, 35, 38, 40, 47};
    }
    static Stream<Arguments> provideAscendingSource(){
        return Stream.of(
                Arguments.of(act1,exp1),
                Arguments.of(act2,exp2)
        );
    }

    @DisplayName("병합정렬 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testBubbleSort(int[] actual, int[] expected) {
        E_MergeSort.solution(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

}