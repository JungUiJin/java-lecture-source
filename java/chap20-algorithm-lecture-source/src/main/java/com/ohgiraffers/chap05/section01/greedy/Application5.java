package com.ohgiraffers.chap05.section01.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Union & Find */
/* 집한 간의 연산을 효율적으로 처리하기 위해 설계 된 데이터 구조
*  특히 집합의 합집합과 특정 원소가 속한 집합의 찾기 연산을 빠르게 처리하는데 유용하다.
*  집합은 ㅓ로 다른 원소들로 구성되며, 초기에는 각 원소가 독립적인 집합을 형성한다. */
public class Application5 {

    static int[] parent;

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

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        // M 개의 학생 쌍 처리
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
            System.out.println("union("+a+","+b+")");
            System.out.println("parent : " + Arrays.toString(parent));
        }

        // 마지막 쌍의 친구 관계 확인
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if(find(x) == find(y)){
            return "YES";
        }else {
            return "NO";
        }

    }

}
