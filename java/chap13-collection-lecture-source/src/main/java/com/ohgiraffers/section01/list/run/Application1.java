package com.ohgiraffers.section01.list.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        /* ArrayList
        * : 배열의 단점을 보완, 배열은 크기 변경 불가, 요송의 추가/삭제/정렬 등이 복잡.
        * 이러한 기능을 메소드로 구현해서 제공하고 있으며 속도가 빨라지는 것은 아니다. */

        /* 다형성을 이용해서 상위 레퍼런스로 ArrayList 객체를 참조할 수 있다.
        *  List 인터페이스 하위의 다양한 구현체들로 타입 변경이 가능하므로
        *  상위 타입으로 선언하는 것이 더 유연한 코드를 작성하는 방법이다. */
        ArrayList aList = new ArrayList();
        List list = new ArrayList();
        Collection clist = new ArrayList();

        /* add 메소드를 통해 element(요소)를 저장할 수 있고 현재는 Object 하위 타입 모두를 저장할 수 있다. */
        aList.add(1);
        aList.add("apple");
        aList.add(45.76);
        aList.add(new Date());
        aList.add("apple");
        /* 1. 저장 순서가 유지되며 index 순번이 적용된다.
        *  2. 중복저장이 가능하다.
        * */
        System.out.println("alist : " + aList);

        /* 저장된 요소의 개술를 반환한다. */
        System.out.println("alist.size() : " + aList.size());

        /* 원하는 위치에 값을 추가 수정 삭제할 수 있다. */
        aList.add(1,"apple");
        aList.set(1,"peach");
        aList.remove(1);

        for(int i=0 ; i<aList.size() ; i++){
            /* get 메소드에 index를 전달하여 하나의 요소에 접근 가능하다. */
            System.out.println(aList.get(i));
        }

        /* 모든 컬렉션 프레임워크는 제네릭 클래스로 작성되어있다. */
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("peach");
        stringList.add("banana");
        stringList.add("kiwi");
        stringList.add("mango");

        /* 저장 순서대로 유지 된 리스트가 정렬을 하면 문자열 오름차순으로 정렬된다. */
        /* Collections 는 컬렉션에서 활용되는 기능들을 static 메소드로 구현해 둔 클래스이다. */
        System.out.println(stringList);
        Collections.sort(stringList);
        System.out.println(stringList);



    }
}
