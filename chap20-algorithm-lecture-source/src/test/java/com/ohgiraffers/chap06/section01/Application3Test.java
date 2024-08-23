package com.ohgiraffers.chap06.section01;

import com.ohgiraffers.chap06.section01.Application3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Application3Test {
    private static Integer input1, input2;
    private static Integer output1,output2;
    private static Application3 application;
    @BeforeAll
    public static void set() {

        /* 예시1 */
        input1 = 6;
        output1 = 3;

        /* 예시2 */
        input2 = 12;
        output2 = 16;
    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }
    @DisplayName("dp3")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void dp3test1(Integer input, Integer output) throws Exception {
        Integer result = Application3.solution1(input);
        Assertions.assertEquals(output, result);
    }
    @DisplayName("dp3")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void dp3test2(Integer input, Integer output) throws Exception {
        Integer result = Application3.solution2(input);
        Assertions.assertEquals(output, result);
    }
}