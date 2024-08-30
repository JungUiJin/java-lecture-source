package com.ohgiraffers.chap01.section01.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(value = "/lifecycleAnnotation")
public class lifecycleTest extends HttpServlet {
    public lifecycleTest() {
        System.out.println("annotation 생성자");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 컨테이너 생성");
    }

    @Override
    public void destroy() {
        System.out.println("annotation 컨테이너 삭제");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 서비스 호출");
    }
}
