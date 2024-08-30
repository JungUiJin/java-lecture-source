package com.ohgiraffers.section02.abstractclass;

/* 추상 클래스를 상속할 경우 추상 메소드를 반드시 오버라이딩 해야한다. */
public class SmartPhone extends Product {
    @Override
    public void abstMethod() {
        System.out.println("Product abst method 오버라이딩 호출");
    }
    public void printSmartPhone(){
        System.out.println("SmartPhone 클래스의 print메소드 호출");
    }
}
