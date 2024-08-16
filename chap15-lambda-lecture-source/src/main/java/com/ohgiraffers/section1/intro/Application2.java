package com.ohgiraffers.section1.intro;

public class Application2 {
    public static void main(String[] args) {

        OuterInterface.Sum sum= (a, b) -> a + b;
        System.out.println(sum.sumTwoNumber(10, 20));

        OuterInterface.Minus minus= (a, b) -> a - b;
        System.out.println(minus.minusTwoNumber(30, 20));

        OuterInterface.Multiple multiple= (a, b) -> a * b;
        System.out.println(multiple.multipleTwoNumber(15, 20));

        OuterInterface.Divide divide= (a, b) -> a / b;
        System.out.println(divide.divideTwoNumber(4000, 20));

    }
}
