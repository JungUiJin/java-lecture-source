package org.example.section03.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* java.util.Scanner 를 사용한 다양한 자료형 값 입력 받기 */

        /* 1. Scanner 객체 생성 */
        Scanner sc = new Scanner(System.in);
        /* 자료형 값 입력받기 */

        /* 2-1. 문자열 입력 : nextLine() */
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        System.out.println("입력 받은 값 : " + name);

        /* 2-2. 정수형 입력 : nextInt() */
        /* 숫자가 아닌 값, int 범위를 넘는 값을 입력하면 InputMismatchException 발생 */
        System.out.print("나이 입력");
        int age = sc.nextInt();
        System.out.println("입력 받은 값 : " + age);

        /* 2-3. 실수형 입력 : nextDouble() */
        /* 정수, 실수 이외에 값 입력시 런타임 에러. */
        System.out.println("키 입력");
        double height = sc.nextDouble();
        System.out.println("입력 받은 값 : " + height);

        /* 2-4. 논리값 입력 : nextBoolean()
        * true, false 이외의 값 입력 시 런타임 에러 */;
        System.out.println("true or false 입력");
        boolean isTrue = sc.nextBoolean();
        System.out.println("입력 받은 값 : " + isTrue);

        /* 2-5. 문자 입력 */
        /* 문자열.charAt(n) : 문자열의 n번 인덱스의 문자 반환
        *  문자열 인덱스를 벗어나는 범위를 입력하면 IndexOutOfBound 런타임 에러 발생*/
        System.out.println("아무 값이나 입력 : ");
        char ch = sc.next().charAt(5);
        System.out.println(ch);
    }
}
