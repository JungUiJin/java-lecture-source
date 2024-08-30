package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_switch {
    public void testSimpleSwitchStatement(){
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 정수 : ");
        int first = sc.nextInt();
        System.out.println("두 번째 정수 : ");
        int second = sc.nextInt();
        System.out.println("연산기호 입력 : ");
        char op = sc.next().charAt(0);
        switch (op){
            case '+':
                System.out.println(first + second);
                break;
            case '-':
                System.out.println(first - second);
                break;
            case '*':
                System.out.println(first * second);
                break;
            case '/':
                System.out.println(first / second);
                break;
            default:
                System.out.println("잘못된 값 입력!");
                break;
        }
        // ->를 사용하면 break를 사용한 것과 동일하며 오히려 작성하면 오류가 발생.
        // 두개 이상의 명령문을 작성해야할 경우 {} 표기해야함.
        // 반환값을 리턴할 수 있슴. 단 반드시 default가 있어야만 함.
        // yield 키워드 : 값을 명시적으로 리턴

        int result = switch (op){
            case '+' -> {
                System.out.println(first + second);
                yield first + second;
            }
            case '-' -> {
                System.out.println(first - second);
                yield first - second;
            }
            case '*' -> {
                System.out.println(first * second);
                yield first * second;
            }
            // second가 0이면 발생할 수 있는 런타임 오류
            case '/' -> {
                System.out.println(first / second);
                yield first / second;
            }
            default -> 0;

        };
    }
}
