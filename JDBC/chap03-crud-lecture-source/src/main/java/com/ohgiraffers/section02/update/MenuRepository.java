package com.ohgiraffers.section02.update;

import com.ohgiraffers.section01.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {
    public int updateMenu(Connection con, Menu menu) {
        PreparedStatement ps = null;
        Properties props = new Properties();
        int result = 0;
        try {
            props.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/mapper/menu-mapper.xml"));

            String sql = props.getProperty("updateMenu");

            ps = con.prepareStatement(sql);

            ps.setString(1, menu.getMenuName());
            ps.setInt(2, menu.getMenuPrice());
            ps.setInt(3,menu.getMenuCode());

            result = ps.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
        }

        return result;
    }
}
