package com.ohgiraffers.associationmapping.section01.manytoone;


import jakarta.persistence.*;

@Entity(name = "section01Menu")
@Table(name = "tbl_menu")
public class Menu {
    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    /* 영속성 전이 : 특정 엔터티를 영속화 할 때 연관 된 엔터티도 함께 영속화 한다는 의미이다.
    *  FetchType.EAGER : 즉시 로딩, FetchType.LAZY : 지연 로딩
    *  @ManyToOne 어노테이션의 기본 속성은 즉시 로딩(한 번에 join 해서 처리) */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryCode")
    private Category category;
    private String orderableStatus;

    public Menu(int menuCode, String menuName,  int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public Menu() {

    }

    public Category getCategory() {
        return category;
    }
}
