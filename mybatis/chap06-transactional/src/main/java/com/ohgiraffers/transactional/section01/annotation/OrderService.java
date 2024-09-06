package com.ohgiraffers.transactional.section01.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    /* sqlSession.getMapper() 대신 @Mapper 가 달려 하위 구현체가 관리 되면 의존성 주입 받을 수 있다. */
    private final MenuMapper menuMapper;
    private final OrderMapper orderMapper;

    public OrderService(MenuMapper menuMapper, OrderMapper orderMapper) {
        this.menuMapper = menuMapper;
        this.orderMapper = orderMapper;
    }

    /*
    * Service 계층부터 개발 할 경우 사용자 입력 값이 어떻게 DTO or Map으로 묶여서
    * Controller 계층에서 넘어오는지를 충분히 고민 한 후 매개변수를 작성한다.
    * */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void registNewOrder(OrderDTO orderDTO) {
        /* 1. 주문 한 메뉴 코드 추출 */
        List<Integer> menuCode = orderDTO.getOrderMenu()
                .stream()
                .map(OrderMenuDTO::getMenuCode)
                .toList();
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCode);
        /* 2. 주문한 메뉴 별로 Menu 엔터티에 담아서 조회 해오기. 부가적인 메뉴의 정보 추출 */
        List<Menu> menus = menuMapper.selectMenuByMenuCodes(map);
        menus.forEach(System.out::println);

        /* 3. 해당 주문 건의 총 합계를 계산 */
        int totalOrderPrice = calcTotalOrderPrice(orderDTO.getOrderMenu(), menus);
        System.out.println(totalOrderPrice);

        /* 4. tbl_order insert
        * OrderDTO -> Order */
        Order order = new Order(orderDTO.getOrderDate(),orderDTO.getOrderTime(),totalOrderPrice);
        orderMapper.registOrder(order);
        System.out.println("orderCode : " + order.getOrderCode());

        /* 5. tbl_order_menu insert */
        for(OrderMenuDTO orderMenuDTO : orderDTO.getOrderMenu()) {
            /* OrderMenuDTO -> OrderMenu(entity) */
            OrderMenu orderMenu = new OrderMenu(order.getOrderCode(), orderMenuDTO.getMenuCode(), orderMenuDTO.getOrderAmount());
            orderMapper.registOrderMenu(orderMenu);
        }
    }

    private int calcTotalOrderPrice(List<OrderMenuDTO> orderMenu, List<Menu> menus) {
        int totalOrderPrice = 0;
        for(int i =0; i < orderMenu.size(); i++) {
            totalOrderPrice += menus.get(i).getMenuPrice() * orderMenu.get(i).getOrderAmount();
        }
        return totalOrderPrice;
    }
}
