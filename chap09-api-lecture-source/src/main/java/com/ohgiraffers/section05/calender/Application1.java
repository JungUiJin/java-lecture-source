package com.ohgiraffers.section05.calender;

import java.util.Date;

public class Application1 {
    public static void main(String[] args) {
        /* 1. 기본 생성자 */
        Date today = new Date();
        System.out.println(today);

        /* 2. 매개변수 생성자 Date(long date) */
        /* 1970년 1월 1일 0시 0분 0초 이후 지난 시간을 밀리세컨드로 계산한다. */
        Date time = new Date(0L);
        System.out.println(time);
    }
}
