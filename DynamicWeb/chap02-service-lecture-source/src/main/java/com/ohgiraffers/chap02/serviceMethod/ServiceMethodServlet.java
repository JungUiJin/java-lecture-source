package com.ohgiraffers.chap02.serviceMethod;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/request-service")
public class ServiceMethodServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* http 프로토콜의 정보를 담고 있는 타입으로 다운캐스팅 */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String httpMethod = request.getMethod();
        System.out.println("httpMethod: " + httpMethod);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
