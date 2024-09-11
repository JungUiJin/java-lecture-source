package com.ohgiraffers.chap05.section01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Application3 {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] times = new int[n][2];

        int count = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (o1, o2) ->{
            // 종료 시간 같다면 시작시간 내림차순
            if(o1[1] == o2[1]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });
          /* 내 코드 */
        int curEnd = times[0][1];

//         1. 시작과 끝이 같은지 2. 끝이 같다면 시작시간이 제일 느린것
//         3. 끝이 다르다면 시작시간이 최근 시작시간과 끝시간 사이인지.

        for(int i=1; i<n; i++) {
            if(times[i][0] == times[i][1]) {
                count++;
            }else if(times[i][0] >= curEnd){
                count++;
                curEnd = times[i][1];
            }
        }
        /* 강사님 코드 */
//        int curEnd = 0;
//
//        for(int i=0; i<n; i++) {
//            /* 앞선 회의가 끝나는 시간과 일치하거나 이후에 시작되는지? */
//            if(times[i][0] == times[i][1]) {
//                count++;
//            }
//            if(curEnd <= times[i][0]){
//                count ++;
//                curEnd = times[i][1];
//            }
//        }



        return count;
    }
}
