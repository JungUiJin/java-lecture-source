package com.ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {

//        Product product = new Product();
        SmartPhone smartPhone = new SmartPhone();
        System.out.println(smartPhone instanceof Product);
        System.out.println(smartPhone instanceof SmartPhone);

        // 다향성을 적용해서 추상 클래스를 레퍼런스 타입으로 사용할 수 있다.
        Product product = new SmartPhone();
        product.abstMethod();
    }
}