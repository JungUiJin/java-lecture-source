package com.ohgiraffers.section01.array;

public class Application5 {
    public static void main(String[] args) {
        // 랜덤한 카드 한 장 뽑아서 출력
        String[] shapes = {"SPADE", "HEART", "DIAMOND", "CLOVER"};
        String [] cardNumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int r1 = 0;
        int r2 = 0;
        for(int i = 0 ; i <5; i++){
            r1 = (int)(Math.random()*4);
            r2 = (int)(Math.random()*13);
            System.out.println(shapes[r1] + " " + cardNumber[r2]);
        }
    }
}
