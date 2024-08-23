package com.ohgiraffers.chap05.section01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Application2 {
    public static int solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int price = Integer.parseInt(st.nextToken());

        int count = 0;

        int k = n-1;

        int[] moneys = new int[n];

        for (int i = 0; i < n; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
        }

        while(true){
            if(price%moneys[k] == 0){
                return price/moneys[k]+count;
            }else{
                count += price/moneys[k];
                price = price%moneys[k];
                k--;
            }
        }

    }
}
