package com.ohgiraffers.chap02.section5.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal<T> {
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /* 전휘 순회 메소드(루트 -> 왼쪽 -> 오른쪽 */
    public List<T> preOder(Node<T> root) {
        List<T> result = new ArrayList<>();
        preOderRec(root, result);
        return result;
    }
    private void preOderRec(Node<T> root, List<T> result) {
        if (root != null) {
            result.add(root.data);
            preOderRec(root.left, result);
            preOderRec(root.right, result);
        }
    }

    /* 후위 순회 */
    public List<T> postOder(Node<T> root) {
        List<T> result = new ArrayList<>();
        postOderRec(root,result);
        return result;
    }
    private void postOderRec(Node<T> root, List<T> result) {
        if (root != null) {
            postOderRec(root.left, result);
            postOderRec(root.right, result);
            result.add(root.data);
        }
    }

    /* 중위 순회 */
    public List<T> inOder(Node<T> root) {
        List<T> result = new ArrayList<>();
        inOderRec(root, result);
        return result;
    }
    private void inOderRec(Node<T> root, List<T> result) {
        if (root != null) {
            inOderRec(root.left, result);
            result.add(root.data);
            inOderRec(root.right, result);
        }
    }
}
