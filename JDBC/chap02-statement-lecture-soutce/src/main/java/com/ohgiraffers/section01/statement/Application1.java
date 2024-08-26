package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.section01.statement.JDBCTemplate.*;

public class Application1 {
    public static void main(String[] args) {
        /* 트랜잭션 처리를 위한 DBMS 연동용 커넥션 객체 생성 */
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            // ResultSet : Statement 객체를 통해 조회 처리 된 결과를 다루는 객체
            rs = stmt.executeQuery("select * from employee");
            while(rs.next()) {
                System.out.print(rs.getString("emp_name") + " ");
                System.out.println(rs.getString("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(rs);
            close(stmt);
            close(con);

        }
    }
}
