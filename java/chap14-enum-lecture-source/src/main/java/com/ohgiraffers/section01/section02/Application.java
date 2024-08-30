package com.ohgiraffers.section01.section02;

public class Application {
    public static void main(String[] args) {
        /* 열거형(enum)을 이용하여 상수 열거 패턴의 단점을 해결하는 것을 이해할 수 있다. */

        /* 1, 열거 타입은 싱글톤 방식으로 구현 되기 때문에 인스턴스의 생성이나 확장이 되지 않는다.
        *  -- 싱글톤(SingleTone): 오직 하나의 인스턴스 생성. */

        /* 2. 컴파일 타임의 타입 안정성을 높여준다. */
        boolean isTrue = enumTest(Foods.MEAL_AN_BUTTER_KIMCHI_STEW, Foods.DRINK_RAW_CUTTLEFISH_SHAKE);
//        boolean isTrue2 = enumTest(3,0);

        /* 3, 상수 이름을 문자열로 출력할 수 있다. */
        System.out.println(Foods.MEAL_BUNGEOPPANG_SHUSI);
        System.out.println(Foods.DRINK_RAW_CUTTLEFISH_SHAKE);
        System.out.println(Foods.MEAL_MINT_SEAWEED_SOUP);

        /* 4. 메소드나 필드를 추가할 수 있다. 근본적으로 불변이라 모든 필드는 final 이어야만 한다. */

        /* 5. 클래스이기 때문에 toString 오버라이딩이 가능하다. */
        for(Foods enumtype : Foods.values()) {
            System.out.println(enumtype);
        }
    }
    private static boolean enumTest(Foods enum1, Foods enum2){
        if(enum1 == enum2) return true;
        return false;
    }
}
