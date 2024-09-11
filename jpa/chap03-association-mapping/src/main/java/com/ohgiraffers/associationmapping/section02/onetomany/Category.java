package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "section02Category")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    /* @OneToMany 의 경우 default FetchType.LAZY로 설정 되어 있다.
    * 따라서 즉시 로딩이 필요한 경우 별도로 설정해주어야 한다. */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryCode")
    private List<Menu> menuList;

    public Category(){

    }
}
