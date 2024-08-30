package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application2 {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.checkEnoughMoney(50000, 60000);
            // 돈이 적은경우
            exceptionTest.checkEnoughMoney(50000, 40000);
            // 가격이 음수인 경우
//            exceptionTest.checkEnoughMoney(-50000, 10000);
            // 가진돈이 음수인 경우
//            exceptionTest.checkEnoughMoney(50000, -60000);

        /* | : 동일한 레벨의 다른 타입의 예외를 하나의 catch 블럭에서 처리할 수있다.
        *  단, 상위타입의 Exception 과 하위 타입의 Exception 이 함께 서술될 수 없다.*/
        }  catch (PriceNegativeException | MoneyNegativeException | NotEnoughMoneyException e ) {
            System.out.println(e.getMessage());
        }
    }
}
