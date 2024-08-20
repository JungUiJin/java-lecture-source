package com.ohgiraffers.chap02.section06.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Practice2 {
    class Jewelry {
        int weight;
        int price;
        Jewelry(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
    }

    public long solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        PriorityQueue<Integer> jewelryHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int totalPrice = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewelry[] jewelryArray = new Jewelry[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelryArray[i] = new Jewelry(weight, price);
        }
        Arrays.sort(jewelryArray, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if(o1.weight == o2.weight){
                    return o2.price - o1.price;
                }
                return o1.weight - o2.weight;
            }
        });

        int[] bagArray = new int[k];
        for(int i = 0; i < k; i++){
            bagArray[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagArray);
        int j=0;
        for(int i = 0; i < k; i++){
            while(j<n && jewelryArray[j].weight <= bagArray[i]){
                jewelryHeap.offer(jewelryArray[j++].price);
            }
            if(!jewelryHeap.isEmpty()){
                totalPrice += jewelryHeap.poll();
            }
        }
        return totalPrice;
    }
}
