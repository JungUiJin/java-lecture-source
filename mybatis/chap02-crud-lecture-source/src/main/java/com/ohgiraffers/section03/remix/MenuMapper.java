package com.ohgiraffers.section03.remix;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();


    MenuDTO selectOneMenu(int menuCode);


    int insertMenu(MenuDTO menu);


    int updateMenu(MenuDTO menu);


    int deleteMenu(int menuCode);
}
