package com.ohgiraffers.section03.interfaceimplements;

public class Application {
    public static void main(String[] args) {
        // 다형성을 이용하여 레퍼런스 타입으로 사용
        InterProduct interProduct = new Product();

        // 오버라이딩 된 메소드 호출
        interProduct.abstMethod();
        interProduct.defaultMethod();
        interProduct.NonStaticMethod();

        // static 메소드 호출
        System.out.println(InterProduct.MAX_NUM);
        System.out.println(InterProduct.MIN_NUM);
    }
}
