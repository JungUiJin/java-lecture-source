package com.ohgiraffers.chap04.section02.tree_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Application2 {

    /* 내가 짠 코드 */
    private static Map<Character, Character[]> node;
    private static StringBuilder sb;
    public static String solution(String input) throws IOException{

        BufferedReader br = new BufferedReader(new StringReader(input));
        node = new HashMap<>();
        sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // node 데이터 입력.
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine()," ");
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            node.put(data,new Character[]{left,right});
        }

        preOder('A');
        sb.append("\n");
        inOder('A');
        sb.append("\n");
        postOder('A');
        return sb.toString();
    }
    // 전위
    static void preOder(char root){
        if(node.containsKey(root)){
            sb.append(root);
            preOder(node.get(root)[0]);
            preOder(node.get(root)[1]);
        }
    }
    // 중위
    static void inOder(char root){
        if(node.containsKey(root)){
            inOder(node.get(root)[0]);
            sb.append(root);
            inOder(node.get(root)[1]);
        }
    }

    // 후위
    static void postOder(char root){
        if(node.containsKey(root)){
            postOder(node.get(root)[0]);
            postOder(node.get(root)[1]);
            sb.append(root);
        }
    }
//    /* 강사님이 짜신 코드 */
//    static class Node {
//        char left;
//        char right;
//
//        Node(char left, char right) {
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    static Node[] tree = new Node[26]; // A~Z 총 26개의 노드
//    static StringBuilder sb = new StringBuilder();
//
//    public static String solution(String input) throws IOException {
//        BufferedReader br = new BufferedReader(new StringReader(input));
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            char parent = st.nextToken().charAt(0);
//            char left = st.nextToken().charAt(0);
//            char right = st.nextToken().charAt(0);
//            tree[parent - 'A'] = new Node(left, right);
//        }
//
//        preorder('A');
//        sb.append("\n");
//        inorder('A');
//        sb.append("\n");
//        postorder('A');
//        return sb.toString();
//    }
//
//    static void preorder(char current) {
//        if (current == '.') return;
//        sb.append(current);
//        preorder(tree[current - 'A'].left);
//        preorder(tree[current - 'A'].right);
//    }
//
//    static void inorder(char current) {
//        if (current == '.') return;
//        inorder(tree[current - 'A'].left);
//        sb.append(current);
//        inorder(tree[current - 'A'].right);
//    }
//
//    static void postorder(char current) {
//        if (current == '.') return;
//        postorder(tree[current - 'A'].left);
//        postorder(tree[current - 'A'].right);
//        sb.append(current);
//    }

}
