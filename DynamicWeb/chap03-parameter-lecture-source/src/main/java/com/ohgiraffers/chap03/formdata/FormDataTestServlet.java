package com.ohgiraffers.chap03.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    /* 서블릿이 매핑 된 주소로 POST 방식의 요청이 발생하면 doPost 메소드가 호출 된다. */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* Tomcat9 버전 이하의 경우 Post 요청일 시 인코딩 설정을 하지 않으면 한글 값이 깨진다. */
        resp.setCharacterEncoding("UTF-8");

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
