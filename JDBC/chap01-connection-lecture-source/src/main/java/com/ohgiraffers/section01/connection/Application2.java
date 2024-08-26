package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {
        Properties props = new Properties();
        Connection con = null;
        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc.config.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            System.out.println("con : " + con);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void close(Connection con) {
        try {
            if(con != null&& !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
