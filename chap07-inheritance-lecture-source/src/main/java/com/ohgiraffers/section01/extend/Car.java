package com.ohgiraffers.section01.extend;

public class Car {
    boolean runningStatus;
    // 모든 클래스는 Object 클래스의 후손이다.
    public Car(){
        super();
        System.out.println("Car 생성자 호출");
    }

    public void run(){
        runningStatus = true;
        System.out.println("달린다!");
    }
    public void stop(){
        runningStatus = false;
        System.out.println("멈춘다!");
    }
    public void soundHorn(){
        if(isRunning()){
            System.out.println("빵빵앙");
        }else{
            System.out.println("주행 중이 아닌 상태에서는 경적을 올릴 수 없습니다.");

        }
    }
    protected boolean isRunning(){
        return runningStatus;
    }
}
