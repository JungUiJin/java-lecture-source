package com.ohgiraffers.chap06.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionalHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> attrs = req.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String attr = attrs.nextElement();
            System.out.println(attr + ": " + req.getAttribute(attr));
        }

        int statusCode = (int) req.getAttribute("jakarta.servlet.error.status_code");
        String message = (String) req.getAttribute("jakarta.servlet.error.message");
        String servletName = (String) req.getAttribute("jakarta.servlet.error.servlet_name");
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>")
                .append(statusCode)
                .append("-")
                .append(message)
                .append("</h1>")
                .append("<p>에러발생 서블릿 명 : ")
                .append(servletName)
                .append("</p>");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(sb.toString());
        out.flush();
        out.close();
    }
}
