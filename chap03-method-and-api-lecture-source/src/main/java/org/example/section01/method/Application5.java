package org.example.section01.method;

public class Application5 {
    public static void main(String[] args) {
        // 메소드 리턴값을 이해하고 활용할 수 있다.
        Application5 app5 = new Application5();
        // 메소드에 반환값이 있을 경우 변수에 담을 수 있다.
        String test = app5.testMethod();
        System.out.println(test);
        //변수에 담지 않고 바로 출력
        System.out.println(app5.testMethod());
        // void 메소드의 경우 컴파일러가 자동으로 추가해주므로 명시적 작성이 필요 없다.
//        return;
//        System.out.println("");
    }

    public String testMethod(){
        return "test";
    }

}
