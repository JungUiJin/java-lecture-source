package org.example.section03.scanner;

import java.util.Scanner;

public class Apllication3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 1. 공백을 포함한 문자열을 입력하게 되면 입력 버퍼에 남아있는 문자열로 인해
        * nextInt()에서 해당 값을 숫자로 변경하지 못함. >>> 런타임 에러 발생
        * 해결방법 : 공백 포함 문자를 받아야 할때는 nextLine() 사용하기 */

//        System.out.println("문자열 입력 : ");
//        String str1 = sc.next();
//        System.out.println(str1);
//
//        System.out.println("숫자 입력 : ");
//        int num1 = sc.nextInt();
//        System.out.println(num1);
//

        /* 2. 입력 버퍼에 남아있는개행문자로 인해 이어지는 nextLine()이 아무 값도 입력 받지 않고 빈 문자열로 처리된다. */
        System.out.println("숫자 입력 : ");
        int num2 = sc.nextInt();
        System.out.println(num2);

        sc.nextLine();

        System.out.println("문자열 입력 : ");
        String str2 = sc.next();
        System.out.println(str2);
    }
}
