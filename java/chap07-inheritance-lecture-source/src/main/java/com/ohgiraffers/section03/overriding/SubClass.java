package com.ohgiraffers.section03.overriding;

public class SubClass extends SuperClass {

    // 메소드명, 리턴 타입, 매개변숭의 갯수,타입,순서 일치해야 성립.
    @Override
//    public void method2(int num){}
//    public void method(int num){return 0;}
//    public void method(String num){}
    public void method(int num){}

    // private 메소드 오버라이딩 불가
//    @Override
//    private void privateMethod(){}

    // final 메소드 오버라이딩 불가.
//    @Override
//    public final void finalMethod(){}

    // 접근 제한자 : 더 넓은 범위로 바뀌는건 괜찮. 더 좁은 범위로는 안댐
    // public > protected > default > private
    @Override
    public void protectedMethod(){}
}
