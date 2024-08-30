package org.example.section01;

public class tesnary {
    public static void main(String[] args)
    {
        // 삼항 연산자에 대해 이해하고 활용할 수 있다.
        // 조건 ? true일때 값 : false일 때 값
        int num1 = 10;
        int num2 = -10;
        String result1 = (num1>0) ? "양수다" : "음수다";
        System.out.println("num1은 " + result1);
        String result2 = (num2>0) ? "양수다" : "음수다";
        System.out.println("num2은 " + result2);

        int num3 = 5;
        int num4 = 0;
        int num5 = -5;

        String result3 = (num3>0) ? "양수다" : (num3 == 0) ? "0이다" : "음수다";
        String result4 = (num4>0) ? "양수다" : (num4 == 0) ? "0이다" : "음수다";
        String result5 = (num5>0) ? "양수다" : (num5 == 0) ? "0이다" : "음수다";
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}
