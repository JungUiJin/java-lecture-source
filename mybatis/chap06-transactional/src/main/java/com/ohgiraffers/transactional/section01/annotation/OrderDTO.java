package com.ohgiraffers.transactional.section01.annotation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/* 테이블의 필드와 꼭 일치할 필요 없이 주문을 위해서 사용자가 넘겨 준 값을 담아
*  계층을 넘어다니며 값을 옮겨 줄 수 있는 클래스를 작성한다. (DTO : Data Tranfer Object) */
public class OrderDTO {
    private LocalDate orderDate;
    private LocalTime orderTime;
    private List<OrderMenuDTO> orderMenu;

    public OrderDTO(){}

    public OrderDTO(LocalDate orderDate, LocalTime orderTime, List<OrderMenuDTO> orderMenu) {
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderMenu = orderMenu;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                ", orderMenu=" + orderMenu +
                '}';
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderMenuDTO> getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(List<OrderMenuDTO> orderMenu) {
        this.orderMenu = orderMenu;
    }
}
