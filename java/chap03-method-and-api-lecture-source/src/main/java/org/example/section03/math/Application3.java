package org.example.section03.math;

import java.util.Random;

public class Application3 {
    public static void main(String[] args) {
        /* java.util.Random */
        Random rand = new Random();

        /* 1. 0~9 범위의 난수 발생 */
        int randomInt = rand.nextInt(10);
        System.out.println(randomInt);
        /* 2. 1~10범위 */
        int randomInt2 = rand.nextInt(10)+1;
        System.out.println(randomInt2);

    }
}
