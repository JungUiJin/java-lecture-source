package com.ohgiraffers.section03.sync;

public class Consumer extends Thread {
    private final Buffer criticalData;

    public Consumer(Buffer criticalData) {
        this.criticalData = criticalData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            criticalData.getData();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
