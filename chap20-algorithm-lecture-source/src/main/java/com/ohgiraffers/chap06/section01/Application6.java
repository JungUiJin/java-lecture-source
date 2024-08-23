package com.ohgiraffers.chap06.section01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

// knapsack 알고리즘 ( 배낭 알고리즘 )
public class Application6 {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 물건 수
        int k = Integer.parseInt(st.nextToken()); // 가방 무게

        int[][] dp = new int[n+1][k+1]; // dp[물건인덱스][무게] = 가치 최적값 기록
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 물건의 무게
            int v = Integer.parseInt(st.nextToken()); // 물건으 가치

            /* 각 물건에 대한 dp 배열의 행의 값을 채워 나가는 작업(가능한 무게 k까지 반복) */
            for(int j = 1; j <= k; j++) {
                if(j<w){
                    /* 해당 물건의 무게보다 낮은 경우 담을 수 없다.
                     *  ==> 가치 값의 변화가 없으므로 이전 행의 값이 그대로 반영 된다.*/
                    dp[i][j] = dp[i-1][j];
                } else {
                    /* 해당 물건의 무게보다 낮은 경우 담을 수 있다.
                    *  ==> 담는다 : 물건 가치 + 해당 무게 빼고 남을 수 있는 가치 vs 담지 않는다. : 이전 행의 값 그대로 반영*/
                    dp[i][j] = Math.max(v+dp[i-1][j-w],dp[i-1][j]);
                }
            }
        }

        return dp[n][k];
    }
}
