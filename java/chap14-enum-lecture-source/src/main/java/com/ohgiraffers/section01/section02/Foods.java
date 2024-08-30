package com.ohgiraffers.section01.section02;

public enum Foods {
    /* 작성 순서대로 0부터 값이 자동으로 부여된다. */
    MEAL_AN_BUTTER_KIMCHI_STEW,
    MEAL_MINT_SEAWEED_SOUP,
    MEAL_BUNGEOPPANG_SHUSI,
    DRINK_RADISH_KIMCHI_LATTE,
    DRINK_WOOLUCK_SMOOTHIE,
    DRINK_RAW_CUTTLEFISH_SHAKE;
//    private final int value ;
    private final int var = 10;


    public void printVar(){
        System.out.println("print var : " + var);
    }
    @Override
    public String toString() {
        return this.name();
    }
}
