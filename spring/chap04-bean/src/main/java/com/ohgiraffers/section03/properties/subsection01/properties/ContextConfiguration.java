package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {
    @Value("${bread.carpbread.name:붕어빵}")
    private String name;
    @Value("${bread.carpbread.price:0}")
    private int price;



    @Bean
    public Product carpBread(){
        return new Bread(name, price, new java.util.Date());
    }
    @Bean
    public Product milk(@Value("${baverage.milk.name}")String name,
                        @Value("${baverage.milk.price:0}")int price,
                        @Value("${baverage.milk.capacity:0}")int capacity){
        return new Beverage(name,price,capacity);
    }
    @Bean
    public Product water(){
        return new Beverage("지리산암반수", 3000, 100);
    }
    @Bean
    @Scope("prototype") // default 값인 singleton 에서 prototype으로 변경.
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

}
