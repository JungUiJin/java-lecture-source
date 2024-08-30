package com.ohgiraffers.chap05.section01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 다익스트라 알고리즘
* : 음의 가중치가 없는 그래프의 한 정점에서 모든 정점까지의 최단 거리를 구하는 알고리즘 */
public class Application4 {
    static int N;
    static int M;
    static int start;
    static int[] dis; // 다른 노드까지의 거리를 저장할 배열.

    static class Edge implements Comparable<Edge> {
        int ver;
        int cost;
        Edge(int ver, int cost) {
            this.ver = ver;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(st.nextToken());
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작정점
            int b = Integer.parseInt(st.nextToken()); // 도착정점
            int c = Integer.parseInt(st.nextToken()); // 가중치
            graph.get(a).add(new Edge(b, c));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(start, 0));
        dis[start] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int now = tmp.ver;
            int nowCost = tmp.cost;

            if(dis[now] < nowCost){continue;}

            for(Edge edge : graph.get(now)){
                /* 거리를 기록해두는 배열에 저장 된 값이
                 현재 비용과 간선을 타고가는 비용을 더한 값보다 크다면.. */
                if(dis[edge.ver] >nowCost + edge.cost){
                    // 새로운 루트를 업데이트 한다.
                    dis[edge.ver] = nowCost + edge.cost;
                    pq.offer(new Edge(edge.ver, nowCost+edge.cost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            if(dis[i] != Integer.MAX_VALUE) sb.append(dis[i]);
            else sb.append("impossible");
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
