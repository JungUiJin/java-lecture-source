package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = (BookService) applicationContext.getBean("bookService");

        bookService.selectAllBooks().forEach(System.out::println);
        System.out.println(bookService.searchBookMySequence(1));
    }
}
