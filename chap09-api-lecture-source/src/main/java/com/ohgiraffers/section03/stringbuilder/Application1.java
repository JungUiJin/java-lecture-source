package com.ohgiraffers.section03.stringbuilder;

public class Application1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("java");
        System.out.println("sb = " + sb + " " + sb.hashCode());

        sb.append("oracle");
        /* 기존 인스턴스와 수정 후의 인스턴스가 동일한 주소값을 가지는 것을 확인할 수 있다. */
        System.out.println("sb = " + sb + " " + sb.hashCode());

    }
}
