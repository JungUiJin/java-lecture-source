package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.Bunny;
import com.ohgiraffers.section02.extend.MethodFarm;
import com.ohgiraffers.section02.extend.Rabbit;
import com.ohgiraffers.section02.extend.Snake;

public class Application2 {
    public static void main(String[] args) {
        /* 메소드 매개변수 제네릭 제약을 사용할 수 있다. */
        MethodFarm methodFarm = new MethodFarm();

        methodFarm.animalType(new Bunny(), new Snake());

//        methodFarm.MammerType(new Snake());
        methodFarm.MammerType(new Rabbit());


    }
}
