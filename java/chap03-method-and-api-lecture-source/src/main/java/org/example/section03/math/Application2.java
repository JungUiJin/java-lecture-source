package org.example.section03.math;

public class Application2 {
    public static void main(String[] args) {
        /* 사용자 지정 범위의 난수 발생 시키기 */
        // (random() * n1) + n2 : n1범위, 0+n2 부터 시작해서 난수 발생
        /* 1. 0~9 사이의 난수 */
        int random1 = (int)(Math.random() * 10);
        System.out.println(random1);
        /* 2. 1~10 사이의 난수 */
        int random2 = (int)(Math.random() * 10)+1;
        System.out.println(random2);
        /* 3. -128에서 127사이의 난수 */
        int random3 = (int)(Math.random() * 256)-128;
        System.out.println(random3);
        /*  */
    }
}
