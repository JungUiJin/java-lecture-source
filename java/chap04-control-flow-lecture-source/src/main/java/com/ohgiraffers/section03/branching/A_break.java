package com.ohgiraffers.section03.branching;

public class A_break {
    // break : 가장 인접한 반복문을 종료.
    public void testSimpleBreakStatuement(){
        int sum = 0;
        int i = 1;
        while(true){
            sum += i;
            if(sum > 100) break;
            i++;
        }
        System.out.println(sum);
    }
    public void testSimpleBreakStatuement2(){
        for(int dan = 2; dan <= 9; dan++){
            System.out.println("===="+dan+"====");
            for(int su = 1; su <= 9; su++){
                if(su>6) break;
                System.out.println(dan+" * "+su+" = "+su*dan);
            }
        }
    }
    public void testJumpBreak(){
        for(;;){
            for(int i = 1; i <= 9; i++){
                System.out.println(i);
                if(i==3) break;
            }
        }
    }
}
