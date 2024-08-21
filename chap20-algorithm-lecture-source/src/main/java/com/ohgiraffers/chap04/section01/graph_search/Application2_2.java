package com.ohgiraffers.chap04.section01.graph_search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BFS 와 x,y 좌표를 활용한 문제를 해결할 수 있다. */
public class Application2_2 {
    // 배추 밭의 가로 세로, 심어진 수
    static int M,N,K;
    // 배추 밭
    static int[][] map;
    // 방문 배열
    static boolean[][] visited;
    // 상하 좌우 개녕의 좌표배열
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    // 탐색하는 x,y의 좌표
    static int cx, cy;


    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 지렁이 개수
        int count=0;

        visited = new boolean[M][N];
        map = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }
        System.out.println("배추밭 출력");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        /* 배추밭내의 배추 찾기 */
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    /* 지렁이 심자! */
                    count ++;
                    /* 해당 위치와 붙어있는 배추밭을 방문 체크한다. */
                    dfs(i,j);
                }
            }
        }

        return count;
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int k = 0; k < 4; k++) {
            cx = x + dirX[k];
            cy = y + dirY[k];
            if(rangeCheck()&&!visited[cx][cy]&&map[cx][cy]==1) {
                visited[x][y] = true;
                dfs(cx,cy);
            }
        }
    }

    /* 상하좌우가 밭의 범위를 넘지 않도록 체크 */
    private static boolean rangeCheck(){
        return cx>=0 && cy>=0 && cx<M && cy<N;
    }
}
