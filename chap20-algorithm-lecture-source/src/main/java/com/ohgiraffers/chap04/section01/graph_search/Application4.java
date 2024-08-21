package com.ohgiraffers.chap04.section01.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Application4<T> {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private List<Integer> visited;    // 해당 정점 방문 여부
    private int N,M,V;
    StringBuilder sb;
    private Queue<Integer> queue;

    public void addVertex(int vertex) {
        // putIfAbsent: key 값이 존재하는 경우 Map의 value를 반환하고,
        // key 값이 존재하지 않는 경우 key와 value를 저장 후 null 반환
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    /* 방향 그래프이기 때문에 from에서 to로 이웃 정점 추가 */
    public void addEdge(int from, int to) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).add(to);
    }

    public String solution(String input) throws IOException {
        queue = new LinkedList<>();
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new StringReader(input));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 정점 초기화
        for (int i = 1; i <= N; i++) {
            addVertex(i);
        }
        // 간선 초기화
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            addEdge(from,to);
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        return sb.toString();
    }

    public void dfs(int start) {
        visited = new ArrayList<>();
        dfsHelper(start, visited);
    }
    private void dfsHelper(int start, List<Integer> visited) {
        if(!visited.contains(start)) { // 이미 방문한 정점이라면 재귀 호출이 return 된다.
            visited.add(start);
            sb.append(start).append(" ");
            for(int v : adjList.getOrDefault(start, new ArrayList<>())) {
                if(!visited.contains(v)) {
                    dfsHelper(v, visited);    // 재귀 함수를 통해 반복 호출을 하되
                }
            }
        }
    }

    public void bfs(int start) {
//        visited = new ArrayList<>();
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(start);     // 시작 정점을 큐에 담음
//        // 큐에 담긴 정점이 없을 때까지 반복
//        while(!queue.isEmpty()) {
//            int vertex = queue.poll();
//
//            if(!visited.contains(vertex)) {
//                visited.add(vertex);
//                sb.append(vertex).append(" ");
//                for(int v : adjList.getOrDefault(vertex, new ArrayList<>())) {
//                    if(!visited.contains(v)) {
//                        queue.offer(v);
//                    }
//                }
//            }
//        }
    }
}
