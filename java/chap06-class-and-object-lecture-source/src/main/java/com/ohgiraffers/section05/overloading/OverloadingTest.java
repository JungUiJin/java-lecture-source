package com.ohgiraffers.section05.overloading;

public class OverloadingTest {
    // 오버로딩  : 같은 클래스 내에서 같은 이름의 메소드를 매개변수부만 다르게 하여 정의하는 것.
    // 사용 이유 :
    // 매개 변수의 종류별로 메소드 내용을 다르게 작성해야 하는 경우가 종종 있는데,
    // 동일 기능의 메소드를 매개변수에 따라 다른 이름을 붙이면 관리가 어려워 지기 때문

    public static void main(String[] args) {
        System.out.println();
    }

    // 오버로딩의 조건
    // 메소드 시그니처가 동일하면 compile error 발생
    // 메소드 시그니처 : 메소드명과 파라미터 선언부를 의미
    // 접근제한자, 봔한명은 오버로딩 성립 요건에 해당하지 않음.
    public void test(){}
//    private void test(){}
//    public int test(){}
    public void test(int num){}
    public void test(int num1, int num2){}
    public void test(int num1, String name){}

    /* 매개변수의 타입, 개수, 순서가 달라야 함. */
}
