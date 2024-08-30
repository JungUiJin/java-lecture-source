package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        // 생성자 합수가 무엇인지 이해하고 선언 및 호출할 수 있다.
        // 기본 생성자 호출
        User user1 = new User();
        // 매개변수 생성자 호출
        User user2 = new User("user01","pass01");
        User user3 = new User("user02","pass02","유관순",new Date());
    }
}
