package com.ohgiraffers.section08.kindsofvariable;

public class KindsOfVariable {
    private int globalNum;  // 전역변수, 인스턴스 변수
    private static int staticNum; //전역변수, 클래스변수

    public void method(int num){ //매개변수(지역변수)
        int localNum; // 지역변수  >>  stack에 할당.

        /* 매개변수는 호출 시 값이 전달 되어 초기화 되지만 지역 변수는 선언 외에 사용을 위해서는
        *  반드시 초기화 해야 한다. */

        System.out.println(num);
//        System.out.println(localNum);
        System.out.println(globalNum);
        System.out.println(staticNum);
    }
    public void method2(){
        /* 지역 변수는 해당 지역에서만 사용이 가능하며
        *  전역 변수는 클래스 내의 모든 영역에서 사용할 수 있다. */
//        System.out.println(localNum);
    }
}
