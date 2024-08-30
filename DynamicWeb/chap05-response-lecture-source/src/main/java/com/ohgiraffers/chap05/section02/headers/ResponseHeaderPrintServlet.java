package com.ohgiraffers.chap05.section02.headers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setHeader("Refresh","1");// 응답 데이터의 Mime 타입 설정
        PrintWriter writer = resp.getWriter();
        long currentTime = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>")
                .append("<head>")
                .append("<title>Response</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(currentTime)
                .append("</h1>")
                .append("</body>")
                .append("</html>");
        writer.println(stringBuilder.toString());
        writer.flush();
        writer.close();

        Collection<String> responseHeader = resp.getHeaderNames();
        for (String header : responseHeader) {
            System.out.println("header: " + header);
        }

    }
}
