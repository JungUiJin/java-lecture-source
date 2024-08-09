package com.ohgiraffers.section01.exception;

public class Application {
    public static void main(String[] args) throws Exception {

        ExceptionTest exceptionTest = new ExceptionTest();
        /* 예외 처리가 강제화 된 메소드를 호출하는 경우 반드시 예외처리가 필요하다
        * 여기서는 throws로 다시 책임을 위임하는 처리를 했다.
        * 단, main 메소드까지 예외를 throws 하면 프로그램은 비정상 종료된다. */
        exceptionTest.checkEnoughMoney(10000, 10000);
        exceptionTest.checkEnoughMoney(10000, 9000);

    }
}
