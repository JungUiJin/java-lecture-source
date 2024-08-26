package com.ohgiraffers.section03.sqlinjection;

import java.sql.*;

import static com.ohgiraffers.section01.statement.JDBCTemplate.close;
import static com.ohgiraffers.section01.statement.JDBCTemplate.getConnection;

/* statement 와 달리 PreparedStatement 는 placeholder 를 통한 sql injection 공격을 막을 수 있게 작성 되어 있어
* 보안적인 측면에서도 더 우수하다. */
public class Application2 {
    private static String empId = "201";
    private static String empName = "' or 1=1 and emp_id='200";
    public static void main(String[] args) {
        Connection conn = getConnection();;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "select * from employee where emp_id = ? and emp_name= ?";
        /* placeholder에 싱글쿼테이션이 들어가면 추가적으로 싱글쿼테이션을 넣어 sql injection 공격을 막는다.
        *  select * from employee where emp_id = '200', and emp_name = ''' or 1=1 and emp_id = ''200' */

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("emp_name") + "님 환영합니다.");
            }else {
                System.out.println("그런애 없다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);
            close(pstmt);
            close(conn);
        }
    }
}
