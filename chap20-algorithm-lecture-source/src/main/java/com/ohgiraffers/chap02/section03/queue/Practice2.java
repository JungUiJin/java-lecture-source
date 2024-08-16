package com.ohgiraffers.chap02.section03.queue;

import java.util.LinkedList;
import java.util.Queue;

/* 트럭 - 백준 (13335) */
public class Practice2 {
    /* w 다리에 올라갈 수 있는 트럭 수 : 다리 길이
    *  l 다리의 최대 하중
    *  truckWeight : 각 트럭 무게
    * */
    public int solution(int w, int l, Integer[] truckWeight) {
        int time = 0;
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeight = 0;
        for (int i = 0; i < truckWeight.length; i++) {
            trucks.add(truckWeight[i]);
        }
        for(int i=0; i<w; i++){
            bridge.add(0);
        }
        while (!bridge.isEmpty()) {
            time++;
            totalWeight -= bridge.poll();
            if(!trucks.isEmpty()){
                if(totalWeight+trucks.peek()<=l){
                    totalWeight += trucks.peek();
                    bridge.add(trucks.poll());
                }else{
                    bridge.add(0);
                }
            }
        }
        return time;
    }

}
