package com.ohgiraffers.chap06.section01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application4 {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());
        int[][] p = new int[n+1][n+1]; // 삼각형 데이터 저장
        int[][] dp = new int[n+1][n+1]; // 경로 최대값 저장
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
                /* dp[i][j]의 값은 dp[i-1][j-1] 또는 dp[i-1][j]의 값중 큰 값을 선택해서 가져간다. */
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+p[i][j];
            }
        }
        for(int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(p[i]));
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(answer < dp[n][i]) {
                answer = dp[n][i];
            }
        }
        return answer;
    }
}
