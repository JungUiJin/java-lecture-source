package com.ohgiraffers.chap02.section5.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* 키값을 정수로, 밸류값을 개수데이터로 설정하여 작성해야함. 수정할것. */
public class Practice1 {
    public String solution(String input) throws IOException {

    BufferedReader br = new BufferedReader(new StringReader(input));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
        int k = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st;
        for (int j = 0; j < k; j++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "I":
                    int a = Integer.parseInt(st.nextToken());
                    map.put(a, a);
                    break;
                case "D":
                    if (map.isEmpty()) {
                        break;
                    }
                    if(st.nextToken().equals("1")) {
                        map.remove(map.lastKey());
                    } else {
                        map.remove(map.firstKey());
                    }
                    break;
            }
        }
        if(map.isEmpty()) {
            sb.append("EMPTY").append("\n");
        }else{
            sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
    }
}
