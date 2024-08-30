package com.ohgiraffers.chap02.section01.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        /* ArrayList */
        List<Integer> list = new ArrayList<>();

        // 요소 추가
        list.add(1);
        list.add(2);
        list.add(3);

        // 요소 조회
        System.out.println(list.get(1));

        // 요소 제거
        list.remove(2);
        System.out.println(list);

        // 리스트 크기
        System.out.println(list.size());

        /* LinkedList */

        List<Integer> list2 = new LinkedList<>();

        // 요소 추가
        list2.add(1);
        list2.add(2);
        list2.add(3);

        // 요소 조회
        System.out.println(list2.get(1));

        // 요소 제거
        list2.remove(2);
        System.out.println(list2);

        // 리스트 크기
        System.out.println(list2.size());
    }
}
