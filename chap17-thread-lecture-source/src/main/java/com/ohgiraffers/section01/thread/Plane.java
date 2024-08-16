package com.ohgiraffers.section01.thread;

public class Plane implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<1000; i++){
            System.out.println("Plane flight...");
            try {
                /* 현재 스레드를 지연시키는 메소드로 전달인자로 밀리세컨초를 전달한다. */
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
