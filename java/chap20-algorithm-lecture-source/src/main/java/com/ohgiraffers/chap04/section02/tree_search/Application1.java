package com.ohgiraffers.chap04.section02.tree_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application1 {

    static int N;
    static List<Integer>[] list;
    static int[] parents;
    static boolean[] visited;

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        parents = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b); // a노드가 연결된 노드를 저장하는 list에 b노드 추가
            list[b].add(a); // b노드가 연결된 노드를 저장하는 list에 a노드 추가
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        /* dfs 이후 parent 노드에는 각 노드의 부모 노드가 담겨 있다. */
        for(int i=2; i< parents.length; i++){
            sb.append(parents[i]).append(" ");
        }
        return sb.toString();
    }
    private static void dfs(int parentNode) {
        /* 이미 방문 한 노드는 부모 노드이고, 부모 노드는 재방문하지 않도록 함. */
        visited[parentNode] = true;

        /* 연결 된 노드를 반복 */
        for(int childNode:list[parentNode]) {
            if(!visited[childNode]) {
                // 부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담는다.
                parents[childNode] = parentNode;
                // 그 자식 노드를 부모로 하는 자식 노드를 탐색한다.
                dfs(childNode);
            }
        }
    }
}
