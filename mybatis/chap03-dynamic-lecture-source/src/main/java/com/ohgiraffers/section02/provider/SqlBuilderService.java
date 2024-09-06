package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

public class SqlBuilderService {
    public void registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        SqlBuiderMapepr mapper = sqlSession.getMapper(SqlBuiderMapepr.class);

        int result = mapper.insertMenu(menuDTO);
        if(result > 0) {
            sqlSession.commit();
            System.out.println("성공");
        }else {
            sqlSession.rollback();
            System.out.println("실패");
        }
    }

    public void modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        SqlBuiderMapepr mapper = sqlSession.getMapper(SqlBuiderMapepr.class);

        int result = mapper.updateMenu(menuDTO);
        if(result > 0) {
            sqlSession.commit();
            System.out.println("성공");
        }else {
            sqlSession.rollback();
            System.out.println("실패");
        }
    }

    public void deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        SqlBuiderMapepr mapper = sqlSession.getMapper(SqlBuiderMapepr.class);

        int result = mapper.deleteMenu(menuCode);
        if(result > 0) {
            sqlSession.commit();
            System.out.println("성공");
        }else {
            sqlSession.rollback();
            System.out.println("실패");
        }
    }
}
