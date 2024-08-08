package com.ohgiraffers.section01.polymorphism;

public class Application2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];

        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        // 각 인스턴스별 고유 메소드 동작을 위해서는 다운 캐스팅이 명시적으로 필요하다.
        for (Animal animal : animals) {
            animal.eat();
            if(animal instanceof Tiger){
                ((Tiger) animal).bite();
            }else if(animal instanceof Rabbit){
                ((Rabbit) animal).jump();
            }
        }
    }
}
