package com.ohgiraffers.chap02.section06.heap;

import java.util.PriorityQueue;

public class Application {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(8);

        // 최소값 조회
        System.out.println(minHeap.peek());
        // 최소값 제거
        System.out.println(minHeap.poll());
        // 제거 후 최소값 확인
        System.out.println(minHeap.peek());
    }
}
