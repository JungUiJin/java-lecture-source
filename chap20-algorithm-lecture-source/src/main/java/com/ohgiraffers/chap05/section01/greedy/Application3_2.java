package com.ohgiraffers.chap05.section01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Application3_2 {
    static class Time implements Comparable<Time> {
        int start;
        int end;
        Time(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Time o) {
            if(this.end > o.end){
                return o.start - this.start;
            }else {
                return this.end - o.end;
            }
        }
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Time> times = new ArrayList<Time>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times.add(new Time(start, end));
        }

        Collections.sort(times);

        /* 강사님 코드 */
        int curEnd = 0;
        int count = 0;

        for(Time time : times) {
            if(time.start == time.end){
                count++;
                curEnd = time.end;
                continue;
            }
            if(time.start >= curEnd){
                count++;
                curEnd = time.end;
            }
        }


        return count;
    }
}
