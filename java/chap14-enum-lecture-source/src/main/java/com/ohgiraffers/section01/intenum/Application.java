package com.ohgiraffers.section01.intenum;

public class Application {
    public static void main(String[] args) {

        /* 1. 타입 안정성 보장이 어렵다. */
        int food = Menu.MEAL_AN_BUTTER_KIMCHI_STEW;
        food = Menu.DRINK_RADISH_KIMCHI_LATTE;

        if(food == Menu.MEAL_AN_BUTTER_KIMCHI_STEW){
            System.out.println("식사 카테고리 : 앙버터 김치찜");
        }

        /* 2. 정수형 상수는 문자열로 출력하기 어렵다. */
        System.out.println(Menu.MEAL_AN_BUTTER_KIMCHI_STEW);
        System.out.println(Menu.MEAL_MINT_SEAWEED_SOUP);
        System.out.println(Menu.MEAL_BUNGEOPPANG_SHUSI);

        /* 3. 정수 열거 그룹에 소한 모든 상수를 순회하는 방법도 쉽지 않다. */
        /* 4. 정수 열거 패턴으로 상수가 선언 된 경우 변경이 살뱅하면 재컴파일이 필요하다. */
    }
}
