package com.ohgiraffers.section03.references;

import java.util.function.Function;

public class Application2 {
    public static void main(String[] args) {
        /* 생성자 메소드 참조 형태 */
        Function<String, Member> function = Member::new;
        Member member1 = function.apply("John");
        Member member2 = function.apply("Jane");
        Member member3 = function.apply("Jack");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
    }
}
