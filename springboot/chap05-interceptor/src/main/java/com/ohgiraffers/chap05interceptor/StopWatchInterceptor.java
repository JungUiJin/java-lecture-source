package com.ohgiraffers.chap05interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* HandlerInterceptor 인터페이스를 구현한 클래스로 작성. */

@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;
    public StopWatchInterceptor(MenuService menuService){
        this.menuService = menuService;
    }

    // 전처리 메소드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle 메소드 호출");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true; // 컨트롤러의 핸들러 메소드 호출로 이어짐, false 면 호출하지 않음.
    }

    // 후처리 메소드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 메소드 호출함");
        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");
        modelAndView.addObject("interval", endTime - startTime);
    }

    /* View가 렌더링 된 후에 동작하는 메소드 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 메소드 호출");
    }
}
