package com.ohgiraffers.section01.extend;

public class RacingCar extends Car{
    public RacingCar() {
        System.out.println("RacingCar 생성자 호출");
    }

    @Override
    public void run() {
        System.out.println("달려!!@!@!@!@!@!2");
    }

    @Override
    public void stop() {
        System.out.println("끼이이이이이이이익");
    }

    @Override
    public void soundHorn() {
        System.out.println("우린 경적이 없음.");
    }
}
