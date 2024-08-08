package com.ohgiraffers.section01.polymorphism;

public class Application {
    public static void main(String[] args) {
        // Rabbit 은 Rabbit 이기도 하지만 Animal이기도 하다.
        // Tiger 는 Tiger 이기도 하지만 Animal이기도 하다.

        /* 부모 타입의 레퍼런스 변수로 자식 인스턴스의 주소 값 참조가 가능하다. */
        Animal a1 = new Rabbit();
        Animal a2 = new Tiger();

        /* 자식 타입의 레퍼런스 변수로 부모 타입의 인스턴스 주소 값 참조는 불가능하다. */
//        Rabbit r1 = new Animal();

        /* 컴파일 당시에는 해당 타입의 메소드와 연결 되어 있다가 (정적 바인딩)
        *  런타임 당시 실제 객체가 가진 오버라이딩 된 메소드로 바인딩이 바뀌어 동작 (동적 바인딩) */
        a1.cry();
        a2.cry();
        // 현재 레퍼런스 변수 타입은 Animalㅇ이기 때문에 Rabit,Tiger의 메소드를 호출 할 수 없다.
        ((Rabbit)a1).jump();
        ((Tiger)a2).bite();
        // 타입 형변환을 잘못 하는 경우 ClassCastException 발생
//        ((Tiger)a1).bite();
        // 레퍼런스 변수가 참조하는 실제 인스턴스가 원하는 타입과 맞는지 비교하는 instanceof 연산자
        System.out.println("a1이 Rabbit 타입인지 확인 : "+(a1 instanceof Rabbit));
        System.out.println("a1이 Tiger 타입인지 확인 : "+(a1 instanceof Tiger));

        System.out.println("a2가 Rabbit 타입인지 확인 : "+(a2 instanceof Rabbit));
        System.out.println("a2가 Tiger 타입인지 확인 : "+(a2 instanceof Tiger));

        System.out.println("a2가 Animal 타입인지 확인 : "+(a2 instanceof Animal));

        System.out.println("a1이 Object 타입인지 확인 : "+(a1 instanceof Object));
        System.out.println("a2가 Object 타입인지 확인 : "+(a2 instanceof Object));

        // 해당 타입이 맞는 경우에만 클래스 형변환을 수행
        if(a1 instanceof Rabbit)((Rabbit)a1).jump();

        // up-casting : 상위 타입으로 형변환 --> 묵시적으로 형변환이 가능.(명시 안해도 ㄱㅊ)
        // down-casting : 하위 타입으로 형변환 --> 묵시적으로 형변환 불가능. (명시해야댐)
        Animal animal1 = (Animal) new Rabbit();
        Animal animal2 = new Rabbit();

        Rabbit rabbit1 = (Rabbit) animal1;
//        Rabbit rabbit2 = animal1;




    }
}
