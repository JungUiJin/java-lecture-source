package com.ohgiraffers.associationmapping.section02.onetomany;


import jakarta.persistence.*;

@Entity(name = "section02Menu")
@Table(name = "tbl_menu")
public class Menu {
    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

}
