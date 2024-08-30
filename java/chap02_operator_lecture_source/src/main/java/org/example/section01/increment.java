package org.example.section01;

public class increment {
    public static void main(String[] args) {
        // 증감 연산자에 대해 이해하고 활용할 수 있다.

        int num = 20;
        num ++;

        // 다른 연산자와 함께 증감 연산자를 사용하는 경우
        int firstNum = 20;
        int result1 = firstNum + 3;
        System.out.println("result1 = " + result1);
        System.out.println("firstNum = " + firstNum);

        // 후위 연산은 다른 연산이 수행 된 후 마지막으로 수행된다.
        int secondNum = 20;
        int result2 = ++secondNum + 3; // secondNum을 1 증가 시키고 다음 처리
        System.out.println("result2 = " + result2);
        System.out.println("secondNum = " + secondNum);
    }
}
