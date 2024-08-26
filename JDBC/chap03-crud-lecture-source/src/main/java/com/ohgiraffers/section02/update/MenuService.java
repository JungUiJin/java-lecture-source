package com.ohgiraffers.section02.update;

import com.ohgiraffers.section01.Menu;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {
    public static void updateMenu(Menu menu){
        Connection conn = getConnection();

        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.updateMenu(conn,menu);

        if(result>0){
            System.out.println("쿼리 성공");
            commit(conn);
        } else {
            System.out.println("쿼리 실패");
            rollback(conn);

        }

        close(conn);
    }
}
