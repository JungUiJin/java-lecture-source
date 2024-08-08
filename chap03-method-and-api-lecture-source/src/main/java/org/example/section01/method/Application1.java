package org.example.section01.method;

public class Application1 {
    public static void main(String[] args) {
        // 메소드 호출에 대한 이해
        System.out.println("main method 호출됨");

        // 작성한 메소드 호출
        Application1 app1 = new Application1(); // 생성자
        app1.methodA();

        System.out.println("main method 종료됨");
    }

    // 접근자 반환 이름(매개변수){ 코드 }
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
