package org.example.section01;

public class logical {
    public static void main(String[] args) {
        /* 논리 연산자에 대해 이해하고 활용할 수 있다. */

        // 1. 1부터 100 사이의 값인지 확인
        int num = 50;
        System.out.println("1 ~ 100 사이인지 확인: "+(num>1&&num<100));

        // 2. 영어 대문자인지 확인
        char ch = 'G';
        System.out.println("영어 대문자인지 확인 : "+ (ch>='A'&&ch<='Z'));

        // 3. 대소문자 상관 없이 영문자 y인지 확인
        char ch2 = 'y';
        System.out.println("영문자 y인지 확인 : "+ (ch2 == 'Y' || ch2 == 'Y'));
        // 영문자인지 확인
        char ch3 = 'a';
        System.out.println("영문자인지 확인 : "+((ch3>='A'&&ch3<='Z')||(ch3>='a'&&ch3<='z')));

        // A&&B : A의 결과가 false 이면 B를 실행하지 않음.
        // >>>> false가 나올 확률이 높은 조건을 앞에 배치하면 연산 횟수를 줄일 수 있다.
        int num1 = 10;
        int result1 = (false && ++num1 >0) ? num1 : num1;
        System.out.println(num1);

        // A||B : A의 결과가 true면 B를 실행하지 않음.
        // >>>> true가 나올 확률이 높은 조건을 앞에 배치하면 연산 횟수를 줄일 수 있다.
        int num2 = 10;
        int result2 = (true || ++num2 >0) ? num2 : num2;
        System.out.println(num2);
    }
}
