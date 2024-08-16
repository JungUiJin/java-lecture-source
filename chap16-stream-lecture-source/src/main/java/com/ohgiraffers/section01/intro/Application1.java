package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("hello", "stream", "test"));

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            if(s.equals("stream")) {
                System.out.println("걸러낸 값 : " + s);
            }
        }

        /* Iterator 대신 stream 기능 사용 */
        list.stream()
                .filter("stream"::equals)
                .forEach(s -> System.out.println("걸러낸 값 : "+s));

    }
}
