package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {
    public void testSimpleIfElseStatement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("divisible by even");
        }else {
            System.out.println("divisible by odd");
        }
        System.out.println("Program terminated");
    }
    public void testNestedIfElseStatement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        if(num % 2 == 0) {
            System.out.println("divisible by 0");
        }else{
            if (num % 2 == 0) {
                System.out.println("divisible by even");
            }else {
                System.out.println("divisible by odd");
            }
        }

        System.out.println("Program terminated");
    }
}
