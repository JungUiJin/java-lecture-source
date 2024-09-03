package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {

    @Select("SELECT now()")
    java.util.Date selectDate();
}
