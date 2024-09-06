package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DynamicSqlMapper {
    List<MenuDTO> selectMenuByPrice(int price);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(Map<String, Set<Integer>> randomMenuCodeList);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);

    int updateMenu(Map<String, Object> criteria);
}
