package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application2 {
    public static void main(String[] args) {
        /* 이전 연산에서 반환 된 값이 다음 연산의 첫 번째 인자로 전달된다. */
        OptionalInt reduceOneParam = IntStream.rangeClosed(1,10)
                .reduce((a,b)->{
                    System.out.println("a="+a+",b="+b);
                    return Integer.max(a,b);
                });
        System.out.println("reduceOneParam = " + reduceOneParam);

        /* reduce 에 인자를 2개 전달하는 경우 첫 번째 인자가 초기값으로 기능한다.
        * reduce 의 결과 값이 반드시 존재하므로 OptionalInt 타입이 아닌 int 타입이 반환 값으로 설정 되어 있다. */

        int reduceTwoParam = IntStream.rangeClosed(1,10)
                .reduce(100, Integer::sum);
    }
}
