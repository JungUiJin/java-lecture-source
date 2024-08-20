package com.ohgiraffers.chap02.section06.heap;

import java.io.IOException;
import java.util.PriorityQueue;

public class Practice1 {
    public String solution(Integer[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int absCompare = Integer.compare(Math.abs(o1), Math.abs(o2));
            if(absCompare == 0) return Integer.compare(o1, o2);
            return absCompare;
        });
        StringBuilder sb = new StringBuilder();
        for(int x : arr){
            if(x==0){
                if(pq.isEmpty()) sb.append("0 ");
                sb.append(pq.poll()).append(" ");
            } else {
                pq.add(x);
            }
        }
        return sb.toString().trim();
    }
}
