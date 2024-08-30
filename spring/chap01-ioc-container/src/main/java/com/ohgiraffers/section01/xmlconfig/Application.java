package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("section01/xmlconfig/spring-context.xml");
        MemberDTO member = (MemberDTO) applicationContext.getBean("member");
        MemberDTO member2 = applicationContext.getBean(MemberDTO.class);
        MemberDTO member3 = applicationContext.getBean("member",MemberDTO.class);
        System.out.println(member3);
    }
}
