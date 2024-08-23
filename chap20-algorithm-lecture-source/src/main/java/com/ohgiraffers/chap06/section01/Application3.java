package com.ohgiraffers.chap06.section01;

public class Application3 {
    /* Top Down */
    static int[] DP;
    public static int solution1(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else if(n == 3) return 1;
        else{
            if(DP[n] == 0) DP[n] = solution1(n - 2) + solution1(n - 3);
        }
        return DP[n];
    }


    public static int solution2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        if(n == 0) return dp[0];
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }
        return dp[n];
    }

    /* Bottom Up */
}
