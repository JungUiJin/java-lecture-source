package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_while {
    public void testSimpleWhileStatement(){
        int i = 1;
        while(i <= 10){
            System.out.println("출력 확인 : " + i);
            i++;
        }
    }
    public void testWhileExample(){
        int dan = 2;
        while(dan<10){
            System.out.println(dan+"단 =========");
            int su = 1;
            while(su<10){
                System.out.println(dan+" * " +su+" = " +dan*su);
                su++;
            }
            dan++;
        }
    }
    public void testWhileExample2(){
        Scanner sc = new Scanner(System.in);
        String str = "";
        while(!str.equals("Exit")){
            System.out.println("문자열 입력 : ");
            str = sc.nextLine();
            System.out.println("입력받은 문자열 : ");
        }
    }
    public void testSimpleDoWhileStatement(){
        // 최초로 한번은 무조건 동작.
        do{
            System.out.println("최초로 한번은 무조건 동작.");
        }while(false);
    }
}
