package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {
        long count = IntStream.rangeClosed(1,10).count();
        long sum = IntStream.rangeClosed(1,10).sum();

        System.out.println("sum = " + sum);
        System.out.println("count = " + count);

        /* 결과 없음을 나타내는 명확한 요구가 있는 메소드의 반환 형식으로는 OptionalInt 사용 */
        OptionalInt max = IntStream.range(1,10).max();
        OptionalInt min = IntStream.range(1,10).min();
        System.out.println("max = " + max);
        System.out.println("max = " + max.getAsInt());
        System.out.println("min = " + min);
        System.out.println("min = " + min.getAsInt());

        /* 중간 연산 이후 최종 연산을 수행 */
        int oddSum = IntStream.rangeClosed(1,10).filter(i -> i % 2 == 1).sum();
        System.out.println("oddSum = " + oddSum);

    }
}
