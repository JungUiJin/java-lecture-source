package com.ohgiraffers.section01;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.*;

/* DBMS */
public class MenuRepository {

    public int insertMenu(Connection conn, Menu menu) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        Properties props = new Properties();
        try {
            props.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/mapper/menu-mapper.xml"));
            String sql = props.getProperty("insertMenu");
            ps = conn.prepareStatement(sql);
            ps.setString(1, menu.getMenuName());
            ps.setInt(2,menu.getMenuPrice());
            ps.setInt(3,menu.getCategoryCode());
            ps.setString(4, menu.getOrderableStatus());

            result = ps.executeUpdate();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
        }

        return result;
    }
}
