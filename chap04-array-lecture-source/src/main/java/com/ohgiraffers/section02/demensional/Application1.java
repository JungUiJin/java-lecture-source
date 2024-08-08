package com.ohgiraffers.section02.demensional;

public class Application1 {
    public static void main(String[] args) {
        // 다차원 배열의 구조를 이해하고 사욜할 수 있다.

        // 1. 배열의 주소를 보관할 레퍼런스 변수 선언
        int[][] iarr1;
        int iarr2[][];
        int[] iarr3;

        // 2. 여러개의 1차원 배열의 주소를 관리하는 배열 생성
//        iarr1 = new int[][];  >> 크기를 지정하지 않음.
//        iarr1 = new int[][4]; >> 주소를 묶어서 관리할 배열의 크기를 정하지 않음.
        iarr1 = new int[3][];

        // 3. 주소를 관리하는 배열의 인덱스마다 배열을 할당.
        iarr1[0] = new int[5];
        iarr1[1] = new int[4];
        iarr1[2] = new int[3]; // 가변 배열 : 1차월 배열 길이가 다름.

        // 2,3번 한번에 처리
        iarr2 = new int[3][5]; // 정변 배열 : 1차원 배열 길이가 다 같음.

        // 4. 각 배열의 인덱스에 차례로 접근해서 값 출력
//        for(int i=0; i<iarr2[0].length; i++){
//            System.out.print(iarr1[0][i] + " ");
//        }
//        System.out.println();
//        for(int i=0; i<iarr2[1].length; i++){
//            System.out.print(iarr1[1][i] + " ");
//        }
//        System.out.println();
//        for(int i=0; i<iarr2[1].length; i++){
//            System.out.print(iarr1[1][i] + " ");
//        }

        // 2중 for문으로 2차원 배열 인덱스 접근
        for(int i=0; i<iarr2.length; i++){
            for(int j=0; j<iarr2[i].length; j++){
                System.out.print(iarr2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
