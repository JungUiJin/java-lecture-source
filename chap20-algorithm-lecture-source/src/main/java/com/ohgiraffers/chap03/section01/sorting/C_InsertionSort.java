package com.ohgiraffers.chap03.section01.sorting;

public class C_InsertionSort {
    public static int[] solution(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for(j = i-1; j >= 0; j--){
                if(arr[j] > temp) arr[j+1] = arr[j];
                else break;

            }
            arr[j+1] = temp;
        }

        return arr;
    }
}
