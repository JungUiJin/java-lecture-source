package com.ohgiraffers.section01.set;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        /* TreeSet 에 대해 이해하고 사용할 수 있다.
        *  ==> TreeSet은 정렬 기준이 있는 데이터를 넣을 수 있다. */
        TreeSet<String> set = new TreeSet<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");

        /* 자동 오름차순 정렬하여 이진 트리의 형태로 요소를 저장하고 있다.
        * 클래스의 CompareTo 메소드 오버라이딩을 기준으로 정렬된다. */
        System.out.println("set : " + set);

        for (String s : set) {
            System.out.println(s);
        }

        Set<Integer> lotto = new TreeSet<>();
        while (lotto.size() < 6) {
            lotto.add((int)(Math.random() * 45)+1);
        }
        System.out.println(lotto);
    }
}
