package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application5 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        /* 큐에 데이터를 넣을 때는 offer() 메소드를 사용한다. */
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        System.out.println(queue);

        /* 큐에서 데이터를 꺼내는 메소드 */
        System.out.println("peek : "+queue.peek());
        System.out.println("queue : " + queue);
        System.out.println("peek : "+queue.poll());
        System.out.println("queue : " + queue);
        System.out.println("peek : "+queue.poll());
        System.out.println("peek : "+queue.poll());
        System.out.println("peek : "+queue.poll());
        System.out.println("peek : "+queue.poll());

        /* queue 에서는 반환할 값이 없을 경우 null 을 반환한다. */
        System.out.println("peek : "+queue.poll());
        System.out.println("queue : " + queue);



    }
}
