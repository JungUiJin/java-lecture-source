package com.ohgiraffers.chap05.section01.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
*  최소 신장 트로
*  주어진 그래프의 모든 정점을 연결하는 부분 그래프 중 가중치의 값이 최소인 트리
*  */
/*
*  크루스칼 알고리즘
*  간선을 오름차순으로 정렬하고 사이클을 형성하지 않도록 최소 신장 트리를 구성하는 방법.
* Union & Find 자료구조를 통해 사이클 여부 확인.
* */
public class Application6 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    /* 특정 원소가 속한 집합을 찾는 연산
     *  이를 통해 집합의 대표 원소를 찾고,
     *  대표 원소를 알면 두 원소가 같은 집합에 속하는지 확인할 수 있다. */
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        // 앞쪽 원소를 root 로 하는 기준으로 작성
        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }

    public static Long solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        long totalWeight = 0L;
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, weight);
        }

        parent = new int[V+1];

        Arrays.sort(edges);
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        /* 가중치가 가장 작은 간선부터 선택해나가는 작업 */
        for(Edge edge : edges){
            if(find(edge.u) != find(edge.v)){
                // 정점을 연결 -> 같은 집합이 된다.
                union(edge.u, edge.v);
                totalWeight += edge.weight;
            }
        }
        return totalWeight;

    }

}
