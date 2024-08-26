package com.ohgiraffers.section01;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/* Service 계층은 Connection 객체 생성 및 소멸, 비즈니스 로직, 트랜잭션 처리 */
public class MenuService {

    public static void registMenu(Menu menu) {
        Connection conn = getConnection();

        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.insertMenu(conn, menu);

        if(result>0){
            commit(conn);
        } else {
            rollback(conn);
        }

        close(conn);
    }
}
