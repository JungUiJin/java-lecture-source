package com.ohgiraffers.chap06.section01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Application1Test {
    private static int input1;
    private static int input2;
    private static int input3;
    private static int output1;
    private static int output2;
    private static int output3;

    @BeforeAll
    public static void set() {

        /* 예시1 */
        input1 = 18;
        output1 = 4;
        input2 = 4;
        output2 = -1;
        input3 = 15;
        output3 = 3;

    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2),
                arguments(input3, output3)
        );
    }

    @DisplayName("greedy1")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void application1test(int input, int output) throws Exception {
        int result = Application1.solution(input);
        Assertions.assertEquals(output, result);
    }

}