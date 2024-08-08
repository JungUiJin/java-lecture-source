package com.ohgiraffers.section09.initblock;

public class Application {
    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product.getInformation());

        Product product2 = new Product("대륙폰",3000,"샤우미");
        System.out.println(product.getInformation());
        System.out.println(product2.getInformation());

    }
}
