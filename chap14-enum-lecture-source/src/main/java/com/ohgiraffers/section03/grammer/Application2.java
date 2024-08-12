package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;

public class Application2 {
    public static void main(String[] args) {
        /* 열거 상수는 열거 객체이므로 생성자를 이용해 열거 상수에 여러 값을 넣을 수 있다. */
        for(Foods food : Foods.values()) {
            System.out.println(food.getName() + " , " + food.getValue());
        }

        /* EnumSet을 활용하여 enum을 Set 자료구조로 가져올 수 있다. */
        EnumSet<Foods> foods = EnumSet.allOf(Foods.class);
        for(Foods food : foods) {
            System.out.println(food.getName() + " , " + food.getValue());
        }

        /* 열거 타입 모든 상수를 Set에 추가 */
        EnumSet<Foods> foods2 = EnumSet.of(Foods.DRINK_WOOLUCK_SMOOTHIE,Foods.DRINK_RADISH_KIMCHI_LATTE, Foods.MEAL_MINT_SEAWEED_SOUP);
        for(Foods food : foods2) {
            System.out.println(food.getName() + " , " + food.getValue());
        }
        EnumSet<Foods> foods3 = EnumSet.complementOf(EnumSet.of(Foods.DRINK_WOOLUCK_SMOOTHIE,Foods.DRINK_RADISH_KIMCHI_LATTE, Foods.MEAL_MINT_SEAWEED_SOUP));
        for(Foods food : foods3) {
            System.out.println(food.getName() + " , " + food.getValue());
        }

    }
}
