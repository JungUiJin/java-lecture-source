package com.ohgiraffers.section03.abstraction;

public class Car {
    private boolean isOn;
    private int speed;

    public void startUp() {
        if(isOn){
            System.out.println("이미 시동이 걸려있습니다.");
        } else {
            System.out.println("시동을 걸었습니다.");
            this.isOn = true;
        }
    }

    public void go() {
        if (isOn){
            System.out.println("차가 움직입니다.");
            speed += 10;
            System.out.println("현재 차의 시속은 " +this.speed+ "km/h 입니다.");
        } else {
            System.out.println("시동이 걸려있지 않습니다.");
        }
    }

    public void stop() {
        if (isOn){
            if(speed >0){
                System.out.println("브레이크를 밟았습니다. 차를 멈춥니다.");
                this.speed = 0;
            }else{
                System.out.println("차가 멈춰있습니다.");
            }
        } else {
            System.out.println("시동이 걸려있지 않습니다.");
        }
    }

    public void turnoff() {
        if (isOn){
            if(speed >0){
                System.out.println("달리는 상태에서는 시동을 끌 수 없습니다.");
            }else{
                System.out.println("시동을 끕니다. 다시 운행하시려면 시동을 켜주세요");
                this.isOn = false;
            }
        } else {
            System.out.println("시동이 이미 꺼져있습니다.");
        }
    }

}
