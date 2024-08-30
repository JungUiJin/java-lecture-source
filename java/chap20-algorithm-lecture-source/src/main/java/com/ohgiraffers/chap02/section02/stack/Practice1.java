package com.ohgiraffers.chap02.section02.stack;


import java.util.Stack;

/* Test 를 만들 때 같은 패키지 경로에 "클래스 이름 + Test 파일" 로 만든다 */
public class Practice1 {
    public String solution(String input){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '('){
                stack.push(String.valueOf(ch));
            }else if(ch == ')'){
                if(stack.isEmpty()){
                    return "NO";
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }
}
