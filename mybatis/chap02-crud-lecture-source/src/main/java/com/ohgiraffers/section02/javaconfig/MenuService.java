package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.section01.xmlconfig.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;


public class MenuService {


    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        return menuList;
    }

    public MenuDTO selectByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.selectOneMenu(menuCode);
        return null;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        return result>0;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        return result>0;
    }

    public boolean deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menuCode);
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        return result>0;
    }
}
