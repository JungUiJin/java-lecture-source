package org.example.section5.typecasting;

public class Application1 {
    public static void main(String[] args) {

        // 자동 형변환
        byte bnum = 1;
        short snum = bnum;
        int inum = snum;
        long lnum = inum;

        // 연산 시 일어나는 형변환
        int num1 = 10;
        int num2 = 20;
        int result1 = num1 + num2;
        System.out.println(result1);

        float fnum = 3.14f;
        double dnum = fnum;
        double result2 = fnum + dnum;

        /* 모든 정수는 모든 실수로 자동 형변환 가능 */
        long eight = 8;
        float four = 4;

        /* 문자형은 int로 자동 형변환 가능 */
        char ch1 = 'a';
        int charNumber = ch1;

        /* int로 type이 정해지지 않은 리터럴 형태의 정수는 char형 변수에 기록 가능 */
        char ch2 = 65;

    }
}
