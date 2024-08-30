package com.ohgiraffers.section1.intro;

public class Application1 {
    public static void main(String[] args) {
        /* 인터페이스에 정의 된 추상 메소드를 활용하는 방법 */

        /* 1. 인터페이스를 상속 받은 클래스를 정의하여 기능을 완성한 뒤 사용. */
        Calculator c1 = new CalculatorImpl();
        System.out.println(c1.sumTowNumber(10,20, 30));

        /* 2. 익명 클래스를 사용하는 방법 */
        Calculator c2 = new Calculator() {
            @Override
            public int sumTowNumber(int a, int b, int c) {
                return a+b+c;
            }
        };
        System.out.println(c2.sumTowNumber(20,40, 50));

        /* 3. lambda 식으로 사용 가능
        * 내부에 하나의 추상 메소드가 선언 된 인터페이스만 람다식의 타깃이 될 수 있다.
        *  ==> 제약조건 : 인터페이스는 추상메소드를 반드시 1개만 가지고 있어야 한다. */
        Calculator c3 = (a, b, c) -> a+b-c;
        System.out.println(c3.sumTowNumber(20,40, 50));
    }
}
