package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("test01","kim"),
                new Member("test02","lee"),
                new Member("test03","jung")
        );
        List<String> memberNameList = memberList.stream()
                .map(Member::getName)
                .collect(Collectors.toList());
        System.out.println(memberNameList);

        String str = memberList.stream()
                .map(Member::getId)
                .collect(Collectors.joining(", "));
        System.out.println(str);

        String str2 = memberList.stream()
                .map(Member::getId)
                .collect(Collectors.joining("||", "**", "**"));
        System.out.println(str2);

        Map<Integer, Long> countByNameLength = memberList.stream().
                collect(Collectors.groupingBy(m -> m.getName().length(), Collectors.counting()));

        System.out.println(countByNameLength);
    }
}
