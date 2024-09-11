package com.ohgiraffers.section02.crud;


import jakarta.persistence.*;

@Entity(name = "Section02Menu") // 이름 생략 시 class명과 동일, 중복 entity 명칭 불가.
@Table(name = "tbl_menu")
public class Menu {

    @Id // primaryKey >> 무조건 있어야 함.
    @Column(name="menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    @Column(name="menu_name")
    private String menuName;
    @Column(name="menu_price")
    private int menuPrice;
    @Column(name="category_code")
    private int categoryCode;
    @Column(name="orderable_status")
    private String orderableStatus;

    public Menu() {

    }

    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Object getMenuName() {
        return menuName;
    }
}
