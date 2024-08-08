package com.ohgiraffers.section03.interfaceimplements;


/* 인터페이스는 인터페이스를 상속할 수 있다.
* 이 때는 extends 라는 키워드를 사용한다.
* 클래스 extends 클래스 -> 단일 상속.8
* 클래스 implements 인터페이스 1 인터페이스 2 -> 다중상속
* 인터페이스 extends 인터페이스1, 인터페이스 2 ->*/
public interface InterProduct {
    // 인터페이스는 상수 필드만 작성 가능하다. 따라서 모든 필드는 묵시적으로 public static final 이다.
    int MAX_NUM=100;
    int MIN_NUM=0;
    // 인터페이스는 생성자를 작성할 수 없다.
//    public InterProduct(){}
    // 인터페이스는 구현부가 있는 non-static 메소드를 가질 수 없다.
//    public void nonStaticMethod();

    public abstract void NonStaticMethod();
    void abstMethod();

    // static 메소드는 작성 가능하다.

    // default 키워드를 사용하면 non-static 메소드도 작성 가능하다.
    // default 메소드는 완성되어 있으므로 오버라이딩이 강제화 되지 않는다.
    public static void staticMethod() {
        System.out.println("static method");
    }
    public default void defaultMethod() {
        System.out.println("default method");
    }
}
