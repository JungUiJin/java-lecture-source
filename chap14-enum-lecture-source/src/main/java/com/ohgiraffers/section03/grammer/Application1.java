package com.ohgiraffers.section03.grammer;

public class Application1 {
    public static void main(String[] args) {

        /* 1, values() : 열거 타입의 모든 값을 배열로 반환 */
        for(Enumtype e : Enumtype.values()) {
            System.out.println("type = " + e);
        }

        /* 2. valueOf() : 해당 이름을 가진 열거 타입 상수 반환 */
        for(Enumtype e : Enumtype.values()) {
            if(e == Enumtype.valueOf("JAVA")) System.out.println("e = " + e);
        }

        /* 3. ordinal() : 열거 타입 상수의 순서를 리턴 */
        for(Enumtype e : Enumtype.values()) {
            System.out.println("ordinal = " + e +" "+ e.ordinal());
        }

        System.out.println(Enumtype.ORACLE.ordinal());

        /* 4. name() : 열거 타입의 문자열 리턴 */
        System.out.println("name : " + Enumtype.ORACLE.name());
        /* 기본적으로는 toString()도 열거 타입의 문자열을 리턴하지만 필요에 따라 오버라이딩 해서 사용 가능하다. */
        System.out.println("name : " + Enumtype.ORACLE.toString());
        System.out.println("name : " + Enumtype.ORACLE);
    }
}
