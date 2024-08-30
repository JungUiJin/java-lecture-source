package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        /* List 인터페이스에 있는 내용을 동일하게 수행할 수 있다. */
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(i+" : "+linkedList.get(i));
        }

        linkedList.remove(1);
        System.out.println();
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(i+" : "+linkedList.get(i));
        }
//        System.out.println(linkedList.isEmpty());
//        linkedList.clear();
//        System.out.println(linkedList.isEmpty());


        /* LinkedList는 ArrayList와 사용 방법이 유사하다. List 인터페이스를 상속 받았기 때문이다.
        * 단, 내부적으로 요ㅗ를 저장하는 방법의 차이가 있는 것이니 특징을 파악하고
        * 적합한 자료 구조를 구현한 클래스를 선택해서 쓰는 것이 좋다.
        * ~first, ~last 접미어를 붙여 순차적 기능을 강조한 함수들이 LinkedArray에 정의되어 있다. */

        linkedList.add("F");
        linkedList.addFirst("0");
        linkedList.addLast("1");
        linkedList.removeFirstOccurrence(1);
        linkedList.removeLastOccurrence(1);

    }
}
