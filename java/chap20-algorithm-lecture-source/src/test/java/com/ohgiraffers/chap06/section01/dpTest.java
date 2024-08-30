package com.ohgiraffers.chap06.section01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class dpTest {
    static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(10,55),
                Arguments.of(40,102334155)
        );
    }
    @ParameterizedTest
    @MethodSource("provideSource")
    @DisplayName("test1")
    void testGetFibonacciNumber1(int input, int output) {
        Integer result = dp.getFibonacciNumber(input);
        assertEquals(output, result);
    }
    @ParameterizedTest
    @MethodSource("provideSource")
    @DisplayName("test2")
    void testGetFibonacciNumber2(int input, int output) {
        Integer result = dp.getFibonacciNumberDp(input);
        assertEquals(output, result);
    }
    @ParameterizedTest
    @MethodSource("provideSource")
    @DisplayName("test3")
    void testGetFibonacciNumber3(int input, int output) {
        Integer result = dp.getFibonacciNumberIter(input);
        assertEquals(output, result);
    }

}