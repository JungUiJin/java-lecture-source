package com.ohgiraffers.section02.initdestroy.subsection01.java;

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
        System.out.println("cart에 담긴 상품" + cart2.getItem());

        /* Spring 컨테이너 종료 전에 프로세스가 종료 되어 destroyMethod 확인이 되지 않으므로
        * 컨테이너 종료 코드를 작성하여 확인한다. */
        ((AnnotationConfigApplicationContext) applicationContext).close();


    }
}
