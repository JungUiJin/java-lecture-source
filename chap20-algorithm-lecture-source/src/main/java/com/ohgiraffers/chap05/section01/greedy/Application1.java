package com.ohgiraffers.chap05.section01.greedy;

public class Application1 {
    public static int solution(int n){
        int count=0;

        while(true){
            /* 5로 나눠진다. */
            if(n%5==0) return n/5 + count;
            else if (n<0) return -1;
            /* 3키로 봉지 하나 사용. */
            n-=3;
            count++;
        }

    }
}
