package com.ohgiraffers.section04.wrapper;

public class Application1 {
    public static void main(String[] args) {

        int num = 129;
        /* Wrapper 클래스의 생성자는 1.9부터 Deprecated 되었다. */

        /* Boxing : int -> Integer */
        Integer num1 = Integer.valueOf(num);
        /* AutoBoxing */
        Integer num2 = num;

        /* UnBoxing : Integer -> int */
        int num3 = num1.intValue();
        /* AutoUnBoxing */
        int num4 = num2;

        /* Integer.valueOf() 메소드가 byte 타입의 범위 숫자는 캐싱 처리하고 있어 num1 == num2가 나올 수 있다. */
        System.out.println(num1 == num2); // Integer 와 Integer 주소 값 비교
        System.out.println(num2 == num3); // Integer, int 값 비교
        System.out.println(num3 == num4); // int, int 값 비교

        /* Instance 의 값 비교는 항상 equals()를 사용한다. */
    }
}
