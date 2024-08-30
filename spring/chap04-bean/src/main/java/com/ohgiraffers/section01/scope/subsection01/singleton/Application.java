package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        /* 슈퍼에 상품이 진열 되어 있다. */
        Product carpBread = applicationContext.getBean("carpBread", Product.class);
        Product milk = applicationContext.getBean("milk", Product.class);
        Product water = applicationContext.getBean("water", Product.class);

        /* 한 손님이 쇼핑 카트를 꺼내 상품을 카트에 담는다. */
        ShoppingCart cart = applicationContext.getBean(ShoppingCart.class);
        cart.addItem(carpBread);
        cart.addItem(milk);
        System.out.println("cart에 담긴 상품" + cart.getItem());

        ShoppingCart cart2 = applicationContext.getBean(ShoppingCart.class);
        cart2.addItem(water);
        System.out.println("cart에 담긴 상품" + cart.getItem());
        /* Bean 의 기본 스코프는 singleton 이다.
        *  singleton 스코프를 갖는 bean은 어플리케이션 내에서 유일한 인스턴스를 갖는다. */
    }
}
