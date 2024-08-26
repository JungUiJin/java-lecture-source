package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.section01.statement.JDBCTemplate.close;
import static com.ohgiraffers.section01.statement.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        try {
            stmt = con.createStatement();
            System.out.print(" 조회 할 사번 입력 : ");
            int empId = sc.nextInt();

            String query = "select emp_id, emp_name from employee where emp_id = '"+empId+"'";
            rs = stmt.executeQuery(query);

            if(rs.next()) {
                System.out.println(rs.getString("emp_name"));
                System.out.println(rs.getString("emp_id"));
            }else{
                System.out.println("그런애 없다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(stmt);
            close(con);
        }
    }
}
