package com.ohgiraffers.section02.extend;



public class MethodFarm {
    /* 매소드 매개변수로 전달 받는 타입 제한 */
    public <T> void animalType(T t1, T t2){

    }
    public <T extends Mammal> void MammerType(T t1){

    }
    public<T extends Reptile> void reptileType(T t1){

    }
    public<T extends Rabbit> void RabbitType(T t1){

    }

}
