package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPricce;
import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        /* ArrayList 사용자 정의 자료형으로 이용하기, 정렬하기 */

        List<BookDTO> bookList = new ArrayList<BookDTO>();
        bookList.add(new BookDTO(1,"홍길동전","허균",11000));
        bookList.add(new BookDTO(2,"홍갈동전","호균",12000));
        bookList.add(new BookDTO(3,"홍굴동전","히균",14000));
        bookList.add(new BookDTO(4,"홍걸동전","하균",13000));
        bookList.add(new BookDTO(5,"홍걀동전","홍균",16000));
        bookList.add(new BookDTO(6,"홍결동전","흑균",15000));

        for (BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }
        /* implements Comparable 을 통해 compareTo 메소드(정렬기준 반환)가 재정의 되어야만 사용 가능하다.
        *  Comparator 인터페이스를 구현한 정렬 기준을 작성한다. */
        Collections.sort(bookList, new AscendingPricce());
        System.out.println("=========== 가격 오름차순 정렬 ===========");
        for (BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }
        System.out.println();

        /* 정렬 기준을 계속 사용하는 경우 별도의 클래스를 만들어서 사용해도 되지만
        *  한 번만 사용하기 위해서 더 간편하게 익명클래스로 구현할 수 있다. */
        System.out.println("=========== 가격 내림차순 정렬 ===========");
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        for (BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }
        System.out.println();

        System.out.println("=========== 제목 오름차순 정렬 ===========");
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        for (BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }
        System.out.println();

        System.out.println("=========== 제목 내림차순 정렬 ===========");
        /* implements Comparable<BookDTO> 수행 후에는 해당 코드가 동작 된다. */
        Collections.sort(bookList);
        for(BookDTO bookDTO : bookList){
            System.out.println(bookDTO);
        }
    }
}
