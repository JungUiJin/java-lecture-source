package com.ohgiraffers.chap06.section01;

public class dp {
    public static int getFibonacciNumber(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return getFibonacciNumber(n-1) + getFibonacciNumber(n-2);
    }

    /* Top-Down 방식
    * 메모리제이션(Memorization) : 연산결과를 메모리에 저장해두었다가, 동이란 입력에 대한 연산을 반복할 때
    * 이전에 계산 된 결과를 재활용 한다. */
    static int[] dp = new int[50];
    static int getFibonacciNumberDp(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        if(dp[n]==0){ // 확인 : 함수 호출 전 해당 입력에 대한 결과가 이미 저장 되어 있는지.
            // 저장 : 계산 되지 않은 값은 연산 후 특정 자료 구조에 저장
            dp[n] = getFibonacciNumber(n-1) + getFibonacciNumber(n-2);
        }
        return dp[n];
    }

    /* 타뷸레이션 : 문제를 부분 문제로 나누어 작은 문제부터 반복 */
    static int getFibonacciNumberIter(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        if(n==0) return arr[0];
        else if(n==1) return arr[1];
        else{
            for(int i=2; i<=n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            return arr[n];
        }

    }
}

