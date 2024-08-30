package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        System.out.println("============selectMembers===========");
        System.out.println(memberService.selectMembers());
        System.out.println("============selectMember===========");
        System.out.println(memberService.selectMember(1L));
    }
}
