package org.example.section01.method;

public class Application4 {
    public static void main(String[] args) {
        // 메소드 전달 인자와(argument) 매개변수(parameter)
        Application4 app4 = new Application4();

        int age = 20;
        app4.testMethod(age,"Kim",'M');

    }
    // int 타입의 매개변수를 전달 받는 메소드 선언
    public void testMethod(int age,String name, final char gender){
        // 매개변수도 일종의 지역변수다. final 키워드 도 사용 가능하다.
        // 단 상수 네이밍 규칙을 선택적으로 따르는 경향이 있다.
        System.out.println("당신의 이름은 "+name+"이고 당신의 나이는 " + age + "세이며 성별은 "+gender+" 입니다람쥐.");
    }
}
