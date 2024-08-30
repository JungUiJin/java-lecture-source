package com.ohgiraffers.chap02.section04.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice1 {
    class Balloon{
        int index;
        int num;
        Balloon(int index, int num){
            this.index = index;
            this.num = num;
        }
    }

    public String solution(Integer[] arr){
        Deque<Balloon> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            deque.push(new Balloon(i+1, arr[i]));
        }

        sb.append(deque.removeFirst().index).append(" ");
        while(!deque.isEmpty()){
            int i = deque.getFirst().num;
            if(i>0){
                for(int j = i+1; j < i; j++){
                    deque.addLast(deque.removeFirst());
                }
                i=deque.getFirst().num;
                sb.append(deque.removeFirst().index);
            } else {
                for(int j = 1; j <-i; j++){
                    deque.addFirst(deque.removeLast());
                }
                sb.append(deque.removeFirst().index);
            }
            if(deque.isEmpty()) break;
            else sb.append(" ");

        }

        return sb.toString();
    }
}
