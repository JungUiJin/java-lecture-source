package com.ohgiraffers.section03.references;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Application1 {
    public static void main(String[] args) {

        BiFunction<String, String, Boolean> biFunction;
        String str1 = "method";
        String str2 = "metho";

        /* 람다식 사용 */
        biFunction = (x,y) -> x.equals(y);
        boolean result = biFunction.apply(str1, str2);
        System.out.println("result : " + result);

        /* 메소드 참조의 형태로 변경 */
        biFunction = String::equals;
        result = biFunction.apply(str1, str2);
        System.out.println("result : " + result);

        Predicate<String> isEqualToSample;
        String sample = "hello";

        /* 메소드 참조 형태로 변경 */
        isEqualToSample = (x) -> x.equals(sample);
        result = isEqualToSample.test("Hello");
        System.out.println("result : " + result);
    }
}
