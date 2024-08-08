package org.example.section01.method;

public class Application3 {
    public static void main(String[] args) {
        // 메소드 전달 인자와(argument) 매개변수(parameter)
        Application3 app3 = new Application3();
        app3.testMethod(25);
        app3.testMethod(32);
//        app3.testMethod("14");
//        app3.testMethod();
        int age = 20;
        app3.testMethod(age * 3);
        byte byteAge = 10;
        app3.testMethod(byteAge);
        long longAge = 20;
        app3.testMethod((int)longAge);
    }
    // int 타입의 매개변수를 전달 받는 메소드 선언
    public void testMethod(int age){
        System.out.println("당신ㄴ의 나이는 " + age + "세 입니다람쥐.");
    }
}
