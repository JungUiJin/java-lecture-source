package com.ohgiraffers.section01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        int result=0;
        /* DML(update, delete, insert)
        *  수행결과가 int 타입으로 반환된다.( 수행 된 행의 개수) */
        String sql = "insert into tbl_menu(menu_name, menu_price, category_code, orderable_status)" +
                "values(?,?,?,?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,"봉골레청국장");
            ps.setInt(2,50000);
            ps.setInt(3,4);
            ps.setString(4,"Y");

            result = ps.executeUpdate();

            if(result>0){
                System.out.println("insert 결과 : " + result);
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(conn);
        }
    }
}
