package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Embeddable;

@Embeddable
public class MenuInfo {
    private String menuName;
    private int menuPrice;
    public MenuInfo() {}
    public MenuInfo(String menuName, int menuPrice) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }
}
