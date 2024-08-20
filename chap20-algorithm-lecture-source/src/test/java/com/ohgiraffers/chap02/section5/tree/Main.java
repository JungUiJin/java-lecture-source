package com.ohgiraffers.chap02.section5.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Long> map = new TreeMap<>();
            StringTokenizer st;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                switch (command) {
                    case "I":
                        long a = Long.parseLong(st.nextToken());
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
        System.out.println(sb);
    }
}
