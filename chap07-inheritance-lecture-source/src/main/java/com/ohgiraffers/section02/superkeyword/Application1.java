package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Application1 {
    public static void main(String[] args) {

        Product product1 = new Product();
        System.out.println(product1.getInformation());

        Product product2 = new Product("S-12321","삼성","갤럭시Z폴드",2030000,new Date());
        System.out.println(product2.getInformation());

        Computer computer1 = new Computer();
        System.out.println(computer1.getInformation());

        Computer computer2 = new Computer("퀄컴 스냅드래곤", 16,512, "안드로이드");
        System.out.println(computer2.getInformation());

        Computer computer3 = new Computer("S-12321","삼성","갤럭시Z폴드",2030000,new Date(), "퀄컴 스냅드래곤", 16,512, "안드로이드");
        System.out.println(computer3.getInformation());

    }
}
