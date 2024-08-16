package com.ohgiraffers.section03.sync;

public class Producer extends Thread {

    private final Buffer criticalData;

    public Producer(Buffer criticalData) {
        this.criticalData = criticalData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            criticalData.setData(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
