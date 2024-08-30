package com.ohgiraffers.section02.encapsulation.problem3;

public class Appication {
    public static void main(String[] args) {
        // 필드에 직접 접근하는 경우 발생할 수 있는 문제점을 이해한다.

        // 필드의 변경이 발생하면 사용한 쪽의 코드를 모두 수정해야 한다.
        // 유지 보수에 악영향을 끼친다.
        Monster monster1 = new Monster();
        monster1.setInfo("두치");
        System.out.println("monster1: " + monster1.getInfo());


        Monster monster2 = new Monster();
        monster2.setInfo("뿌꾸");
        System.out.println("monster2: " + monster2.getInfo());

        Monster monster3 = new Monster();
        monster3.kinds = "프랑켄";
        monster3.hp = -200;
    }
}
