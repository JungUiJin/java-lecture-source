package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {

    public int deleteMenu(Connection conn, int menuId) {
        PreparedStatement ps = null;
        Properties props = new Properties();
        int result = 0;
        try{
            props.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/mapper/menu-mapper.xml"));
            String sql = props.getProperty("deleteMenu");
            ps = conn.prepareStatement(sql);
            ps.setInt(1, menuId);
            result = ps.executeUpdate();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }finally {
            close(ps);
        }

        return result;
    }
}
