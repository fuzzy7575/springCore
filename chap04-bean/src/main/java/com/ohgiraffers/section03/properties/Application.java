package com.ohgiraffers.section03.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguratrion.class);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(water);

        System.out.println("cart1에 담긴 내용 : " + cart1.getItem());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(milk);

        System.out.println("cart2에 담긴 내용 : " + cart2.getItem());

        ((AnnotationConfigApplicationContext)context).close();

    }
}
