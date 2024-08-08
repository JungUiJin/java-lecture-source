package org.example.section01.method;

public class Application2 {
    public static void main(String[] args) {
        System.out.println("main method 호출됨");

        // 작성한 메소드 호출
        Application1 app1 = new Application1(); // 생성자
        app1.methodA();
        app1.methodB();
        app1.methodC();

        System.out.println("main method 종료됨");
    }
    public void methodA() {
        System.out.println("methodA 호출됨");
        methodB();
        System.out.println("methodA 종료됨");
    }
    public void methodB() {
        System.out.println("methodB 호출됨");
        methodC();
        System.out.println("methodB 종료됨");
    }
    public void methodC() {
        System.out.println("methodC 호출됨");
        System.out.println("methodC 종료됨");
    }
}
