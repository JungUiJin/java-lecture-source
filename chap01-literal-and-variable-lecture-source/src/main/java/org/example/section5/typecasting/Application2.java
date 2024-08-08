package org.example.section5.typecasting;

public class Application2 {
    public static void main(String[] args) {

        // 정수끼리의 강제 형변환
        long lnum = 8;
        int inum = (int)lnum;
        short snum = (short)inum;

        // 실수 끼리의 강제 형변환
        double dnum = 8.0;
        float fnum = (float)dnum;

        // 문자형을 int 미만의 자료형으로 형변환 할 경ㅇ우 강제 형변환이 필요
        char ch ='a';
        byte bnum2 = (byte)ch;
        short snum2 = (short)ch;

    }
}
