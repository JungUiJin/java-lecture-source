package com.ohgiraffers.chap02.section07.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class DirectedGraphTest<T> {

    private DirectedGraph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new DirectedGraph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,5);
        graph.addEdge(2,6);
        graph.addEdge(3,4);
        graph.addEdge(4,6);
        graph.addEdge(7,3);
        /*
        *     1 → 2 → 5
        *     ↓     ↘
        * 7 → 3 → 4 → 6
        * */
    }


    static Stream<Arguments> provideForDfsStack(){
        return Stream.of(
                Arguments.arguments(1, Arrays.asList(1, 3, 4, 6, 2, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForDfsStack")
    void testDfsStack(Integer start, List<Integer> expected){
        List<Integer> result = graph.dfsUsingStack(start);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> provideForDfsRecursion(){
        return Stream.of(
                Arguments.arguments(1, Arrays.asList(1, 2, 5, 6, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForDfsRecursion")
    void testDfsRecursion(Integer start, List<Integer> expected){
        List<Integer> result = graph.dfsUsingRecursion(start);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> provideForBfsQueue(){
        return Stream.of(
                Arguments.arguments(1, Arrays.asList(1, 2, 3, 5, 6, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForBfsQueue")
    void testDfsQue(Integer start, List<Integer> expected){
        List<Integer> result = graph.bfsUsingQueue(start);
        Assertions.assertEquals(expected, result);
    }


    static Stream<Arguments> provideForHasPath(){
        return Stream.of(
                Arguments.arguments(1, 3, true),
                Arguments.arguments(1, 7, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForHasPath")
    void testDfsHasPath(Integer start,Integer end ,boolean expected){
        boolean result = graph.hasPath(start,end);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideForHasPath")
    void testBfsHasPath(Integer start,Integer end ,boolean expected){
        boolean result = graph.hasPath(start,end);
        Assertions.assertEquals(expected, result);
    }
}