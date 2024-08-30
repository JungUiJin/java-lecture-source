package com.ohgiraffers.chap03.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    /* 서블릿이 매핑 된 주소로 GET 방식의 요청이 발생하면 doGet 메소드가 호출 된다. */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* HttpServletRequest 객체로 부터 요청 시 전달 한 값을 getParameter 메소드를 추출할 수 있다.
        *  getParameter 는 문자열값으로 반환된다. */
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        java.util.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");
        String[] hobbies = req.getParameter("hobbies").split(",");

        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("birthday : " + birthday);
        System.out.println("gender : " + gender);
        System.out.println("national : " + national);
        System.out.println("hobbies : " + Arrays.toString(hobbies));
    }

}
