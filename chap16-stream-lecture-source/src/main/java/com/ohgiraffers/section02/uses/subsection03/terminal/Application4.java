package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Java", "Spring", "Springboot");

        boolean anyMatch = stringList.stream().anyMatch(str -> str.contains("c")); // 하나라도 매치 되는게 있으면 true
        boolean allMatch = stringList.stream().allMatch(str -> str.length()>5); // 모두 매치 되면 true
        boolean noneMatch = stringList.stream().noneMatch(str -> str.contains("c")); // 모두 매치 안되면 true

        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);

    }
}
