package com.ohgiraffers.section03.grammer;

public enum Foods {
    /* 작성 순서대로 0부터 값이 자동으로 부여된다. */
    MEAL_AN_BUTTER_KIMCHI_STEW(0,"앙버터 김치찜"),
    MEAL_MINT_SEAWEED_SOUP(1, "민트미역국"),
    MEAL_BUNGEOPPANG_SHUSI(2, "붕어빵 스시"),
    DRINK_RADISH_KIMCHI_LATTE(3,"열무김치라떼"),
    DRINK_WOOLUCK_SMOOTHIE(4,"우럭스무디"),
    DRINK_RAW_CUTTLEFISH_SHAKE(5,"생갈치쉐이크");
//    private final int value ;
    private final String name;
    private final int value;

    Foods(int value, String name) {
        this.value = value;
        this.name = name;
    }
    public int getValue(){return value;}
    public String getName(){return name;}
}
