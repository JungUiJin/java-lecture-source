package com.ohgiraffers.chap04.section01.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application3 {

    static int[][] map;
    static boolean[][] visited;
    static int N, M; // 가로세로

    static int cx, cy;

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    static Queue<Node> queue = new LinkedList<>();

    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        /* 입력 값 공백 없이 들어오는 문자를 int 배열에 넣기 */
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            for(int j=0; j<ch.length; j++) {
                map[i][j] = ch[j]-'0';
            }
        }

        bfs(0,0);

        // 도착지의 값을 반환
        return map[N-1][M-1];
    }

    private static void bfs(int x, int y) {
        queue.add(new Node(x,y));
        visited[x][y] = true;

        /* 상하좌우에 배추가 심어져 있다면 해당 위치를 방문한 것으로 표시하고 queue 를 통해 탐색하는 작업을 반복 */
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i = 0; i < 4; i++){
                cx = cur.x+dirX[i];
                cy = cur.y+dirY[i];
                if(rangeCheck()&&!visited[cx][cy]&&map[cx][cy]==1){
                    map[cx][cy] += map[cur.x][cur.y];
                    queue.add(new Node(cx,cy));
                    bfs(cx,cy);
                }
            }
        }
    }
    private static boolean rangeCheck(){
        return cx>=0 && cy>=0 && cx<N && cy<M;
    }
}
