package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class C_IfElseIf {
    public void testSimpleIfElseIfStatement(){

        Scanner sc = new Scanner(System.in);

        System.out.println("학생 이름 입력 : ");
        String name = sc.nextLine();

        System.out.println("학생 성적 입력 : ");
        int score = sc.nextInt();

        String grade = "";
        if(score >= 90){
            grade = "A";
        }else if(score >= 80){
            grade = "B";
        }else if(score >= 70){
            grade = "C";
        }else if(score >= 60){
            grade = "D";
        }else{
            grade = "F";
        }

        System.out.println(name+"의 점수는 "+score+"점이며 성적은"+grade+"이다.");
    }
    public void testNestedIfElseIfStatement(){

        Scanner sc = new Scanner(System.in);

        System.out.println("학생 이름 입력 : ");
        String name = sc.nextLine();

        System.out.println("학생 성적 입력 : ");
        int score = sc.nextInt();

        String grade = "";

        if(score >= 90){
            grade = "A";
            if(score >= 95) grade += "+";
        }else if(score >= 80){
            grade = "B";
            if(score >= 85) grade += "+";
        }else if(score >= 70){
            grade = "C";
            if(score >= 75) grade += "+";
        }else if(score >= 60){
            grade = "D";
            if(score >= 65) grade += "+";
        }else{
            grade = "F";
        }
        System.out.println(name+"의 점수는 "+score+"점이며 성적은"+grade+"이다.");
    }
    public void ImproveTestNestedIfElseIfStatement(){

        Scanner sc = new Scanner(System.in);

        System.out.println("학생 이름 입력 : ");
        String name = sc.nextLine();

        System.out.println("학생 성적 입력 : ");
        int score = sc.nextInt();

        String grade = "";
        if(score >= 90){
            grade = "A";
        }else if(score >= 80){
            grade = "B";
        }else if(score >= 70){
            grade = "C";
        }else if(score >= 60){
            grade = "D";
        }else{
            grade = "F";
        }
        if(score >= 60 && score %10 > 5 || score == 100){
            grade += "+";
        }

        System.out.println(name+"의 점수는 "+score+"점이며 성적은"+grade+"이다.");
    }
}
