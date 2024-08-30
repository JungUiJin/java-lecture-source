package com.ohgiraffers.section03.branching;

public class B_countinue {
    public void testSimpleContinueStatemente(){
        // continue : 가장 인접한 반복문의 실행 건너뜀.
        for(int i =1; i<=100; i++){
            if(i%4!=0||i%5!=0) continue;
            System.out.println(i);
        }
    }
    public void testSimpleContinueStatemente2(){
        for(int dan = 2; dan <= 9; dan++){
            System.out.println("===="+dan+"====");
            for(int su = 1; su <= 9; su++){
                if(su%2==0) continue;
                System.out.println(dan+" * "+su+" = "+su*dan);
            }
        }
    }
    public void testJumpContinue(){
        label:
        for(int dan = 2; dan <= 9; dan++){
            System.out.println("===="+dan+"====");
            for(int su = 1; su <= 9; su++){
                if(su%2==0) continue label;
                System.out.println(dan+" * "+su+" = "+su*dan);
            }
        }
    }
}
