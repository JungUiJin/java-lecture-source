package com.ohgiraffers.chap04.section01.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* DFS를 활용하는 예제를 이해할 수 있다. */
public class Application1 {
    static int node, edge;
    static int[][] map;
    static boolean[] visited;
    static int count = 0;
    public static Integer solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        node=Integer.parseInt(br.readLine());
        edge=Integer.parseInt(br.readLine());

        map = new int[node+1][node+1]; // 0번 인덱스 제외하고 사용

        /* 방문배열 생성(지나간 노드를 다시 방문하지 않기 위함 - stackoverflow방지 */
        visited = new boolean[node+1];

        StringTokenizer st;
        for(int i=1;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            /* 무방향 그래프의 경우 양쪽에 표시해 두어야 함 */
            map[a][b]= map[b][a] = 1;
        }

        dfs(1);

        return count;
    }

    /* 재귀함수로 dfs 알고리즘을 구현할 메소드 */
    private static void dfs(int node){
        // 이미 방문한 정점이라면 재귀 호출이 return 된다.
        visited[node]=true;
        for(int i =0; i<map[node].length;i++){
            if(map[node][i]==1&& !visited[i]) {
                count++;
                dfs(i);
            }
        }

    }

}
