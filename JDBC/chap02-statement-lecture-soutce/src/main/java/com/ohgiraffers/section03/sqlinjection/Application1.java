package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.section01.statement.JDBCTemplate.*;

public class Application1 {
    private static String empId = "200";
    private static String empName = "' or 1=1 and emp_id='200";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from employee where emp_id = '"+ empId + "' and emp_name='"+empName+"'";

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next()){
                System.out.println(rs.getString("emp_name") + "님 환영합니다.");
            }else {
                System.out.println("그런애 없다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }
}
