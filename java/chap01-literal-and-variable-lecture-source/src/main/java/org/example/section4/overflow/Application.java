package org.example.section4.overflow;

public class Application {
    public static void main(String[] args) {
        byte num = 127; // byte의 최댓값 127 (2^7 -1)
        System.out.println("num1 = " + num);
        num ++;
        // 최댓값을 넘어 부호비트를 반전 >> 오버플로우
        System.out.println("num1 = " + num);

        byte num2 = -128;
        num --;
        System.out.println("num2 = " + num2);

        /* 오버플로우, 언더플로우는 컴파일 에러는 발생하지 않지만 최댓값, 최소값을 고려하여 자료형을 선택해야한다. */
        int firstNum = 1000000;
        int secondNum = 700000;
        System.out.println("multi = " + firstNum * secondNum);

        long longMulti = (long)firstNum * secondNum;
        System.out.println("longMulti = " + longMulti);
    }
}
