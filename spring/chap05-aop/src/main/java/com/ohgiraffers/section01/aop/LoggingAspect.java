package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
public class LoggingAspect {
    // Pointcut : 여러 join point 를 매치하기 위해 지정한 표현식
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut(){

    }
    // Before : 핵심 기능 수행 전 동작
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
        // JoinPoint 객체를 통해 현재 조인포인트의 메소드명, 인수 값 등 자세한 정보를 액세스 할 수 있다.
        System.out.println("before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){
            System.out.println("before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    // After : 핵심 기능 수행 후 동작 (정상 수행 또는 오류 발생 무관)
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        // JoinPoint 객체를 통해 현재 조인포인트의 메소드명, 인수 값 등 자세한 정보를 액세스 할 수 있다.
        System.out.println("before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){
            System.out.println("before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    // AfterReturning
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturn(JoinPoint joinPoint, Object result){
        if(result != null && result instanceof Map){
            ((Map<Long,MemberDTO>) result).put(100L, new MemberDTO(100L,"반환 값 가공"));
        }
    }

    // AfterThrowing
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrow(JoinPoint joinPoint, Exception exception){
        System.out.println("after throwing exception : " + exception);
    }

    // Around : 핵심 기능 시작과 끝을 감싸고 동작
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around before : " + joinPoint.getSignature());

        Object result = joinPoint.proceed();

        System.out.println("around after : " + joinPoint.getSignature());

        return result;
    }

}
