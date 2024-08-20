package com.ohgiraffers.chap02.section07.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {
    // 정점과 이웃 정점을 저장할 map, 가중치는 Map 의 Integer 타입으로 표기
    private Map<T, Map<T,Integer>> adjList; // 정점과 이웃 정점을 저장할 맵

    public WeightedGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        // key 값이 존재하는 경우 Map 의 value 를 반환
        // key 값이 존재하지 않는 경우 key와 value를 저장 후 null 반환
        adjList.put(vertex, new HashMap<>());
    }
    // 간선 추가 시 가중치도 함께 추가 됨
    public void addEdge(T from, T to, int weight) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).put(to, weight);
    }

    public void removeVertex(T vertex) {
        adjList.values().forEach(edge -> edge.remove(vertex));
        adjList.remove(vertex);
    }

    /* 방향 그래프이기 때문에 간선 제거 시 from 에서 to 를 제거 */
    public void removeEdge(T from, T to) {
        Map<T,Integer> edges = adjList.get(from);
        if(edges != null) edges.remove(to);
    }
}
