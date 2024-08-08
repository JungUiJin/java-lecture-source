package org.example.section1.literal;

public class Applicatoin2 {
    public static void main(String[] args) {
        /* 값을 연산하여 출력할 수 있다.
         * 이 때, 값의 형태에 따라 사용할 수 있는 연산자의 중류와 연산의 결과가 달라진다.*/

        /* 2. 숫자 리터럴 */
        // 정수와 정수
        System.out.println(123+456);
        System.out.println(123-456);
        System.out.println(123*456);
        System.out.println(123/456);
        System.out.println(123%456);
        // 실수와 실수
        System.out.println(12.3+45.6);
        System.out.println(12.3-45.6);
        System.out.println(12.3*45.6);
        System.out.println(12.3/45.6);
        System.out.println(12.3%4.56);
        // 정수와 실수
        System.out.println(123+45.6);
        System.out.println(123-45.6);
        System.out.println(123*45.6);
        System.out.println(123/45.6);
        System.out.println(123%4.56);

        // 2. 문자 연산
        // 문자와 문자
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');
        // 문자와 정수
        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 2);
        System.out.println('a' / 2);
        System.out.println('a' % 2);
        // 문자와 실수
        System.out.println('a' + 1.0);
        System.out.println('a' - 1.0);
        System.out.println('a' * 2.0);
        System.out.println('a' / 2.0);
        System.out.println('a' % 2.0);
        // 3. 문자열 리터럴의 연산
        // 문자열과 문자열 연산
        System.out.println("hello" + "world");
        //System.out.println("hello" - "world");			//에러 발생
        //System.out.println("hello" * "world");			//에러 발생
        //System.out.println("hello" / "world");			//에러 발생
        //System.out.println("hello" % "world");			//에러 발생
        // 문자열과 다른 리터럴 연산
        System.out.println("helloworld" + 123);
        System.out.println("helloworld" + 123.456);
        System.out.println("helloworld" + 'a');
        System.out.println("helloworld" + true);
        System.out.println("123" + "456");
        // 4. 논리 리터럴의 연산
        //System.out.println(true + false);				//에러 발생
        //System.out.println(true - false);				//에러 발생
        //System.out.println(true * false);				//에러 발생
        //System.out.println(true / false);				//에러 발생
        //System.out.println(true % false);				//에러 발생
        //System.out.println(true + 1);				//에러 발생
        //System.out.println(true - 1);				//에러 발생
        //System.out.println(true * 1);				//에러 발생
        //System.out.println(true / 2);				//에러 발생
        //System.out.println(true % 2);				//에러 발생
    }
}
