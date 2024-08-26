package com.ohgiraffers.section01.statement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;
        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/section01/jdbc-config.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            System.out.println("con : " + con);
            return con;
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Connection con) {
        try {
            if(con != null&& !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Statement stmt) {
        try {
            if(stmt != null&& !stmt.isClosed()) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet rs) {
        try {
            if(rs != null&& !rs.isClosed()) rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
