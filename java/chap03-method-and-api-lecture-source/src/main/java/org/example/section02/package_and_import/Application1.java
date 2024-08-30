package org.example.section02.package_and_import;

import org.example.section01.method.Calculator;
import static org.example.section01.method.Calculator.max;

public class Application1 {
    public static void main(String[] args) {
        /* 패키지에 대해 이해할 수 있다. */
        /* 클래스명은 원래 패키지명을 포함하고 있으며
        * 다른 패키지에 존재하는 클래스를 사용하는 경우 풀 클래스명을 사용해야 한다.
        * */
        // non-static 메소드
        Calculator calculator = new Calculator();
        System.out.println(calculator.min(10, 20));
        // static 메소드
        System.out.println(Calculator.max(10, 20));
        // static 메소드 호출 시 import static을 하면 클래스명도 생략하고 호출할 수 있다.
        System.out.println(max(10,20));
    }
}
