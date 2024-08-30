package com.ohgiraffers.section02.looping;

import java.util.Random;
import java.util.Scanner;

public class A_for {
    public void testSimpleForStatement(){
        for( int i = 0; i < 10; i++ ){
            System.out.println("출력 : "+i);
        }
    }
    public void testForExample(){
        int sum = 0;
        for( int i = 1; i <= 10; i++ ){
            sum+=i;
        }
        System.out.println("1부터 10까지의 합 : "+sum);
    }
    public void testForExample2(){
        int randomNum = (int)(Math.random()*6)+5;
        int sum = 0;
        for( int i = 1; i <= randomNum; i++ ){
            sum+=i;
        }
        System.out.println("1부터 "+randomNum+"까지의 합 : "+sum);
    }
    public void testForExample3(){
        /* 숫자 두 개를 입력 받아 작은 수에서 큰 수까지의 합계를 구한다.
        * 동일한 숫자는 입력하지 않는다는 가정으로 해결한다.*/
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번 째 값 입력 : ");
        int firstNum = sc.nextInt();
        System.out.println("두번 째 값 입력 : ");
        int secondNum = sc.nextInt();

        int max = 0;
        int min = 0;

        if( firstNum > secondNum) {
            max = firstNum;
            min = secondNum;
        }else{
            max = secondNum;
            min = firstNum;
        }
        int sum = 0;
        int randomNum = (int)(Math.random()*(max-min))+min;
        for( int i = min; i <= max; i++ ){
            sum += i;
        }
        System.out.println(sum);
    }
    public void printSimpleGugudan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("출력 할 구구단의 단 수 : ");
        int dan = sc.nextInt();
        if(dan >=2 && dan <=9){
            for( int i = 1; i <= 9; i++ ){
                System.out.println(dan + " * " + i +" = " +(dan*i));
            }
        }else{
            System.out.println("2에서 9사이의 값을 입력하시오.");
        }
    }
}
