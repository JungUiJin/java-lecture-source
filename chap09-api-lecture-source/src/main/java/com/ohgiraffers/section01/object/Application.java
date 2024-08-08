package com.ohgiraffers.section01.object;

public class Application {
    public static void main(String[] args) {
        Book book1 = new Book(1, "홍길동전", "허균", 10000);
        Book book2 = new Book(2, "목민심서", "정약용", 10000);
        Book book3 = new Book(3, "삼국사기", "김부식", 10000);

        /* java.lang.Object 클래스의 toString
        *  인스턴스가 생성 될 때 사용한 full class name + @ + 16진수 해시코드(인스턴스 주소)가 문자열로 반환*/
        System.out.println(book1.toString());

        /* 레퍼런스 변수를 출력하면 자동으로 toString()을 호출한다. 이 점을 이용하여 toString을 재정의 해서 사용한다. */
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println();

        Book book4 = new Book(4, "혼공자", "저자", 20000);
        Book book5 = new Book(4, "혼공자", "저자", 20000);

        System.out.println(book4.hashCode());
        System.out.println(book5.hashCode());
        /* 동일 객체 : 주소가 동일한 인스턴스
        *  동등 객체 : 주소가 다르더라도 필드 값이 동일한 인스턴스
        * Object 의 hashCode(), equals()는 주소값을 기반으로 동일 객체에 대한 판단을 하지만
        * Book 에 재작성 된 메소드는 동등 객체에 대한 판단을 하도록 한다. */
        System.out.println(book4 == book5);
        System.out.println(book4.equals(book5));
    }
}
