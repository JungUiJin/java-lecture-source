package com.ohgiraffers.section06.objectarray;

public class Car {
    private String modelNum;
    private int maxSpeed;

    public Car(String modelNum, int maxSpeed) {
        this.modelNum = modelNum;
        this.maxSpeed = maxSpeed;
    }
    public void driveMaxSpeed(){
        System.out.println(modelNum + "이(가) 최고 시속" + maxSpeed + "로 달리고 있습니다.");
    }
}
