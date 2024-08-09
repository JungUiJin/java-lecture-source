package com.ohgiraffers.section01.exception;

public class Application2 {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.checkEnoughMoney(10000,20000);
            exceptionTest.checkEnoughMoney(20000,10000);
            System.out.println("상품구입 가능티비");
        }catch (Exception e){
            // catch : try 안에서 예외 발생 시 catch블럭의 코드가 실행된다.
//            throw new RuntimeException(e);
            System.out.println("상품구입 불가능티비");
            e.printStackTrace();
        }
        // 예외가 발생하더라도 catch 블럭 실행 후 프로그램의 수행 흐름으로 돌아와 정상 종료 된다.
        System.out.println("프로그램이 종료됨니담");
    }
}
