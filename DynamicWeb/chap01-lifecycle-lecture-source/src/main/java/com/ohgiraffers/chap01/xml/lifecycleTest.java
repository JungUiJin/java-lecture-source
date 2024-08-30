package com.ohgiraffers.chap01.xml;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class lifecycleTest extends HttpServlet {
    public lifecycleTest() {
        System.out.println("생성자 호출");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 호출");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 메소드 호출");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }

}
