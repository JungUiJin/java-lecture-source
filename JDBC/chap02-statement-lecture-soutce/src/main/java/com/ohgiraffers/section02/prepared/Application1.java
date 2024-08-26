package com.ohgiraffers.section02.prepared;

import java.sql.*;
import java.util.Scanner;

import static com.ohgiraffers.section01.statement.JDBCTemplate.close;
import static com.ohgiraffers.section01.statement.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        try {
            // PreparedStatement : 쿼리를 운반하고 결과를 반환하는 객체
            // 객체 생성 시 이미 sql 구문이 전달 되었으므로 실행 시에는 전달하지 않는다.
            pstmt = con.prepareStatement("select * from employee");
            rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.print(rs.getString("emp_name") + " ");
                System.out.println(rs.getString("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
            close(con);
        }
    }
}
