package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    /* 타겟 오브젝트 */
    private final Student student;
    public Handler(Student student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("======== 공부가 너무 하고 싶습니다 ㅜㅜ ========");
        System.out.println("호출 대상 메소드 : " + method);
        for (Object arg : args) {
            System.out.println("전달인자 " + arg);
        }

        method.invoke(student, args);

        System.out.println("===== 공부 다 하고 자러갑니다람쥐 ======");

        return proxy;
    }
}
