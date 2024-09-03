package com.ohgiraffers.chap04exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice : 해당 어노테이션이 적용 된 클래스의 @ExceptionHandler 는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("(전역 범위의 예외처리 발생)message : " + e.getMessage());

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String memberRegistException(MemberRegistException e, Model model){
        System.out.println("(전역 범위의 예외처리 발생)message : " + e.getMessage());
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e){
        return "error/default";
    }
}
