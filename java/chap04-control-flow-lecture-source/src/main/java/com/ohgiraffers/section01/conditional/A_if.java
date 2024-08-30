package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class A_if {
    public void testSimpleIfStatement(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("divisible by even");
        }
        System.out.println("Program terminated");
    }
    public void testNestedIfStatement(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        if(num > 0) {
            if (num % 2 == 0) {
                System.out.println("divisible by even");
            }
        }else{
            System.out.println("divisible by minus");
        }
        System.out.println("Program terminated");
    }
}
