package com.ohgiraffers.section03.interfaceimplements;

public class Product implements InterProduct{

    /* interProduct의 추상 메소드는 반드시 구현해야 한다. (오버라이딩 강제화) */

    @Override
    public void NonStaticMethod() {

    }

    @Override
    public void abstMethod() {

    }

    /* static 메소드는 오버라이딩 할 수 없다. */

    /* default 메소드는 오버라이딩이 강제화 되지 않는다. 선택적으로 오버라이딩 한다. */

}
