package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.List;
import java.util.stream.IntStream;

public class Application4 {
    public static void main(String[] args) {
        /* 스트림의 중계 연산 중 sorted 에 대해 이해하고 적용할 수 있다. */

        List<Integer> integerList = IntStream.of(5,10,88,2,1,32)
                .boxed()
                .sorted((a,b) -> b - a)
                .toList();
        System.out.println(integerList);
    }
}
