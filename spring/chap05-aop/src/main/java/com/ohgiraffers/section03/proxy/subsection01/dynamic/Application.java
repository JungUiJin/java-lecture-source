package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {
        /* Proxy?
        * Target Object의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체(대리인)
        *
        * 생성방법
        * 1. JDK Dynamic Proxy
        *  - T.O 의 타입이 반드시 interface
        * 2. CGLib
        *  - T.O 의 타입이 Class 여도 가능
        *  - 바이트 코드를 조작하여 초기 설정 비용은 있지만 재 호출 시 빠르게 동작함.
        * */

        Student student = new OhgiraffersStudent();
        Handler handler = new Handler(student);
        Student proxy =
                (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[]{Student.class}, handler);

        proxy.study(16);
    }
}
