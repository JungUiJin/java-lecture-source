package com.ohgiraffers.section03.stringbuilder;

public class Application2 {
    public static void main(String[] args) {
        // SpringBuilder 생성
        StringBuilder sb1 = new StringBuilder();
        // 용량(현재 버퍼의 크기)를 정수형으로 반환하며 문자열 길이 +16이 기본값.
        System.out.println(sb1.capacity());

        for (int i = 0; i < 50; i++) {
            // 문자열에 인자값 추가.
            sb1.append(i);
            System.out.println("sb1 : " + sb1);
            System.out.println("sb1.capacity() = " + sb1.capacity());
            System.out.println("sb1.hashCode() = " + sb1.hashCode());
        }

        StringBuilder sb2 = new StringBuilder("javaoracle");
        System.out.println("delete() : " + sb2.delete(2,5));
        System.out.println("deleteCharAt() : " + sb2.deleteCharAt(0));
        System.out.println("Sb2 = " + sb2);

        System.out.println("insert() : " + sb2.insert(0,"abc"));
        System.out.println("insert() : " + sb2.insert(0,"s"));
        System.out.println("insert() : " + sb2.insert(sb2.length(),"jdbc"));

        System.out.println(sb2.reverse());

        // String 클래스와 동일하게 charAt, indexOf, lastIndexOf, length, replace, substring...)

    }
}
