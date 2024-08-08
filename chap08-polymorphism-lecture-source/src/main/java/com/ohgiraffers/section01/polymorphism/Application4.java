package com.ohgiraffers.section01.polymorphism;

public class Application4 {
    public static void main(String[] args) {
        Application4 a = new Application4();
        a.getRandomAnimal().run();
    }
    /* 다향성을 적용하지 않으면 각각의 동물을 반환하는 메소드를 별도로 작성해야 한다. */
    public Animal getRandomAnimal(){
        int random = (int) (Math.random() * 2);
        return random == 0? new Rabbit() : new Tiger();
    }
}
