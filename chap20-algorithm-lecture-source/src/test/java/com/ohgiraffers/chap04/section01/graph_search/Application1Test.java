package com.ohgiraffers.chap04.section01.graph_search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Application1Test {
    static String input;
    static Integer output;

    @BeforeAll
    static void setUp() {
        input=  "7\n" +
                "6\n" +
                "1 2\n" +
                "2 3\n" +
                "1 5\n" +
                "5 2\n" +
                "5 6\n" +
                "4 7\n";
        output=4;
    }

    static Stream<Arguments> provideSource(){
        return Stream.of(
                Arguments.arguments(input,output)
        );
    }

    @DisplayName("dfs1")
    @ParameterizedTest
    @MethodSource("provideSource")
    void testDfs1(String input,Integer output) throws IOException {
        Integer result = Application1.solution(input);
        assertEquals(output,result);
    }
}