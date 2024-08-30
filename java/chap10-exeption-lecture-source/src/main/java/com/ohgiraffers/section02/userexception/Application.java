package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.ExceptionTest;
import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application {
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

            /* 예외 발생 상황별로 catch 블럭을 따로 작성해서 처리할 수 있고,
            *  상위 타입의 Exception 을 이용해서 통합적으로 처리할 수도 있다.
            *  단, 상위 타입의 Exception 이 먼저 기술되면 아래로 코드가 도달할 수 없으므로 컴파일 에러가 발생한다.
            *  서술 순서는 하위 타입 -> 상위타입 순으로 기재한다. */
        }  catch (PriceNegativeException e) {
            System.out.println(e.getMessage());
        } catch (MoneyNegativeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            /* 예외 여부와 상관 없이 실행할 내용 */
            System.out.println("finally 블럭의 내용이 동작함.");
        }

    }
}
