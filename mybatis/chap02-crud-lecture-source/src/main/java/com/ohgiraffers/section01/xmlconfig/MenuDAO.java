package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        /* 메소드의 첫 번째 인자로 어떠한 SQL 구문을 수행할 것인지를 전달한다.
        * Mapper의 nameSpace와 id로 구분한다. */
        return sqlSession.selectList("menuMapper.selectAllMenu");
    }

    public MenuDTO selectByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("menuMapper.selectByMenuCode", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("menuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("menuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("menuMapper.deleteMenu", menuCode);
    }
}
