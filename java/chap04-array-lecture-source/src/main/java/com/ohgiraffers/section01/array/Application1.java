package com.ohgiraffers.section01.array;

public class Application1 {
    public static void main(String[] args) {
        // 배열의 선언 및 할당
        int[] arr = new int[5];

        // 하나의 이름으로 관리되는 연속 된 메묄 공간이며, 해당 공간을 찾아갈 인덱스가 있다.
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        // 인덱스를 반복문으로 처리할 수 있다.
        for (int i = 0, value=0; i < arr.length; i++) {
            arr[i] = value += 10;
            System.out.println(arr[i]);
        }
        int sum = 0;
        // 향상된 for문 : for(변수 선언 : 배열) >> 배열의 첫번째 인덱스부터..
        // 배열 인덱스의 값을 꺼내서 int j라는 변숭에 담아 사용하는 맥락임.
        // >> j에 값을 담더라도 배열의 값 변화 x
        for (int j : arr) {
            System.out.println("j = " +j);
            sum += j;
        }
        System.out.println("sum = "+sum);

    }
}
