package com.ohgiraffers.section07.statickeyword;

public class Application {
    public static void main(String[] args) {
        // static 키워드를 필드에서 사용

        /* Static 객체가 생성되는 순간 Static이라는 독립된 메모리 공간이 할당된다.
        * ----> 프로그램이 시작되는 순간 생성되며, 인스턴스를 계속 생성해도 Static은 한개만 생성되어 다같이 공유한다. */

        StaticFieldTest sft1 = new StaticFieldTest();

        sft1.increaseNonStaticCount();
        sft1.increaseStaticCount();

        System.out.println(sft1.getNonStaticCount());
        System.out.println(sft1.getStaticCount());

        StaticFieldTest sft2 = new StaticFieldTest();

        sft2.increaseNonStaticCount();
        sft2.increaseStaticCount();

        System.out.println(sft2.getNonStaticCount());
        System.out.println(sft2.getStaticCount());
    }
}
