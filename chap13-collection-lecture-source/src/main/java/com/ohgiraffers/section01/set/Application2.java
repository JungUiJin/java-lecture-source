package com.ohgiraffers.section01.set;

import java.util.LinkedHashSet;

public class Application2 {
    public static void main(String[] args) {
        LinkedHashSet<String> lhset = new LinkedHashSet<>();
        lhset.add("A");
        lhset.add("B");
        lhset.add("C");
        lhset.add("D");
        lhset.add("E");

        /* HashSet 이 가지는 기능을 모두 가지고 있으며 추가적으로 저장 순서를 유지하는 특징을 가지고 있다. */

        System.out.println("lhset = " + lhset);
    }
}
