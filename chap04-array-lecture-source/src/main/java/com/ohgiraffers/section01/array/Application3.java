package com.ohgiraffers.section01.array;

public class Application3 {
    public static void main(String[] args) {
        // 배열에 초기화 되는 자료형별 기본 값을 이해할 수 있다.
        // 지역 변수는 반드시 초기화해야만 접근 가능하지만.
        // 힙 영역에 할당 될 경우 초기값이 설정된다.

        int[] iarr = new int[10];
        for (int i = 0; i < iarr.length; i++) {
            System.out.println("iarr[" + i + "] = " + iarr[i]);
        }

        // 기본 값 외의 값으로 ㅊ초기화하면서 배열을 생성하고 싶을 경우 블럭을 사용한다.
        int[] iarr2 = {11, 22, 33, 44, 55};
        for (int i = 0; i < iarr2.length; i++) {
            System.out.println("iarr2[" + i + "] = " + iarr2[i]);
        }

        // 문자열도 배열로 사용할 수 있다.
        String[] sarr = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < sarr.length; i++) {
            System.out.println("sarr[" + i + "] = " + sarr[i]);
        }


    }
}
