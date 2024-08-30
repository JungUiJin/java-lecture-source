package com.ohgiraffers.section01.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /* HashSet 클래스를 이해하고 사용할 수 있다. */

        HashSet<String> set = new HashSet<>();

        /* 다향성을 적용하여 상위 인터페이스 타입을 사용 가능 */
        Collection<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        /* Set 계열에 데이터 추가 시 add() 메소드 사용
        *  --> 삽입 순서에 상관 없이 저장. 내부적인 hash 연산을 통해 데이터를 관리*/
        set.add(new String("a")); // 주소값이 다름.
        set.add(new String("b"));
        set.add(new String("c"));
        set.add(new String("d"));
        set.add(new String("e"));

        System.out.println("set: " + set);

        /* 중복된 값을 저장하지 않음.
        * 동일 객체 뿐만 아니라 동등 객체도 중복 값으로 판단하여 처리한다.
        * String 클래스에 hashCode(), equals() 가 오버라이딩 되어 있기 때문이다. */
        set.add(new String("a")); // 주소값이 다름. 동등객체
        System.out.println("set: " + set);

        /* 해당 객체 포함 여부를 동등 객체 기준으로 판단한다.
        * 내부적으로 equals 메소드를 호출해서 사용한다. */
        System.out.println(set.contains("a"));

        /* 저장 된 객체를 인덱스 기준으로 순회할 수 있다.
        * 반복문을 통한 연속 처리 방법 */
        Object[] arr = set.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " : " + arr[i]);
        }

        /* Collection 인터페이스 상위 타입인 Iterable 인터페이스에 iterator() 메소드가 정의 되어 있다.
        * 따라서 Collection 타입이라면 반복자를 통한 순회가 가능하다. */
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }

        System.out.println();

        for(String s: set){
            System.out.print(s);
        }
    }
}
