package com.ohgiraffers.section03.delete;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {
    public static void deleteMenu(int menuId){
        Connection conn = getConnection();
        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.deleteMenu(conn, menuId);

        if(result > 0){
            System.out.println("쿼리 성공");
            commit(conn);
        } else{
            System.out.println("쿼리 실패");
            rollback(conn);
        }
    }
}
