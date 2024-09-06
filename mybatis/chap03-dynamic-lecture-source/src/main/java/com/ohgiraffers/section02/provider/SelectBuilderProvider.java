package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SelectBuilderProvider {
    public String selectAllMenu(){
        return new SQL()
                .SELECT("menu_code")
                .SELECT("menu_name")
                .SELECT("menu_price")
                .SELECT("category_code")
                .FROM("tbl_menu")
                .WHERE("orderable_status = 'Y'").toString();
    }
    public String searchMenuByNameOrCategory(SearchCriteria searchCriteria){
        SQL sql = new SQL();
        sql.SELECT("menu_code", "menu_name", "menu_price", "category_code")
        .FROM("tbl_menu");
        if("category_code".equals(searchCriteria.getCondition())){
            sql.JOIN("tbl_category USING category_code")
                    .WHERE("orderable_status = 'Y'")
                    .AND()
                    .WHERE("category_code = #{categoryCode}");
        }else if("menu_name".equals(searchCriteria.getCondition())){
            sql.WHERE("orderable_status = 'Y'", "menu_name LIKE CONCAT('%',#{ value },'%')");
        }
        return sql.toString();
    }
}
