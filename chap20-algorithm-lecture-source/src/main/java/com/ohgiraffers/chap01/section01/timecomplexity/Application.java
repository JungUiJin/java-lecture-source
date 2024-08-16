package com.ohgiraffers.chap01.section01.timecomplexity;

import java.util.Arrays;

public class Application {
    /* 시간 복잡도를 이해할 수 있다. */
    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 16, 4, 7, 14, 5};
        System.out.println(getFirst(arr));

        for(int i : reverse(arr)){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(binarySearch(arr,5));

        System.out.println(fibonacci(10));
    }

    /* 상수 시간 O(1) */
    private static int getFirst(int[] arr){
        return arr[0];
    }

    /* 로그시간 O(log n) */
    private static int binarySearch(int[] arr, int target){
        /* 초기 세팅 */
        Arrays.sort(arr); // 내부적으로 nlongn 만큼의 시간이 걸리지만 지금은 고려 x

        /* 배열의 처음과 끝을 지정하는 위치(인덱스)를 담은 변수(포인터) */
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;

    }

    /* 선형 시간 O(n)*/
    private static int[] reverse(int[] arr){
        int[] reversed = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            reversed[i] = arr[arr.length-1-i];
        }

        return reversed;
    }

    /* 지수시간 O(2^n) */
    private static int fibonacci(int n){
        if(n<=1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
