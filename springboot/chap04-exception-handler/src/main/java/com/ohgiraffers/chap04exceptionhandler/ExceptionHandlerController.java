package com.ohgiraffers.chap04exceptionhandler;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {
    @GetMapping("/controller-null")
    public String nullPointerExceptionTest(){
        String str = null;
        System.out.println(str.charAt(0)); // 의도적으로 NullPointerException 발생
        return "/";
    }

    @GetMapping("/controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if (check) throw new MemberRegistException("(특정 범위의 예외처리 발생) 당신 같은 사람은 회원으로 받을 수 없습니다.");
        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("(특정 범위의 예외처리 발생)message : " + e.getMessage());

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String memberRegistException(MemberRegistException e, Model model){
        System.out.println("(특정범위의 예외처리 발생) message : " + e.getMessage());
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }
}
