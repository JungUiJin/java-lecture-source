package com.ohgiraffers.section02;

import java.util.Scanner;

public class daemonthread {
    public static void main(String[] args) {
        /* 일반 스레드는 다른 스레드가 종료 되어도 본인의 작업을 마저 실행한다.
        *  데몬 스레드로 생성한 스레드는 다른 스레드가 모두 종료 되면 함께 종료 된다.*/
        Thread t = new Thread(()->{

                try {
                    for(int i=10; i>0; i--) {
                        System.out.println(i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        });

        t.setDaemon(true);
        t.start();

        Scanner sc = new Scanner(System.in);
        System.out.print("카운트 다운을 멈추려면 아무 키나 입력하세요 : ");
        String str = sc.nextLine();
        System.out.println("입력한 값 : " + str);
        sc.close();
        System.out.println("main end ===============");
    }
}
