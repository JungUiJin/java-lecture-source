package com.ohgiraffers.chap01.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class lifecycleTest extends HttpServlet {
    public lifecycleTest() {
        System.out.println("생성자 생성");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("컨테이너 생성");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("서비스 호출");
    }

    @Override
    public void destroy() {
        System.out.println("컨테이너 삭제");
    }
}
