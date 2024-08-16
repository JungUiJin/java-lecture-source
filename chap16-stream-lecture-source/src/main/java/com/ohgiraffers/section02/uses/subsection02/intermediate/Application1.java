package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {

        /* filter : 스트림에서 특정 데이터만 컬러내는 메소드, 매개변수로 Predicate(boolean을 반환) 인터페이스를 전달한다. */
        IntStream intStream = IntStream.range(0, 10);
        intStream.filter(i -> i%2 == 0).forEach(System.out::println);

    }
}
