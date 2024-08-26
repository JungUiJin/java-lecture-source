package com.ohgiraffers.section02.prepared;


import java.sql.*;
import java.util.Scanner;

import static com.ohgiraffers.section01.statement.JDBCTemplate.*;

/*
* PreparedStatement 는 Statement 와 달리 최초 한 번 쿼리를 파싱하고 컴파일하고 캐싱하여
* 다시 재해석 하는 과정을 생략함으로써 불완전하게 작성된 쿼리 실행의 경우는 Statement 보다 빠르다.
* */
public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("사번 입력 : ");
        String empId = sc.nextLine();
        String entYn = "N";

        /* PreparedStatement 는 Statement 와 달리 placeholder '?' 를 활용한 하나의 문자열 형태로 쿼리를 작성한다. */

        String query = "select emp_id,emp_name from employee where emp_id = ? and emp_yn = ?";



        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            pstmt.setString(2,entYn);
            rs= pstmt.executeQuery();

            if(rs.next()) {
                System.out.println(rs.getString("emp_id") + " " +rs.getString("entYn"));
            }else{
                System.out.println("그런애 없다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);
            close(pstmt);
            close(con);
        }
    }
}
