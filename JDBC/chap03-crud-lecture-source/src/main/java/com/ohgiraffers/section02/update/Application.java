package com.ohgiraffers.section02.update;

import com.ohgiraffers.section01.Menu;

import java.util.Scanner;

import static com.ohgiraffers.section02.update.MenuService.updateMenu;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴의 번호를 입력하시오. : ");
        int menuCode = sc.nextInt();
        sc.nextLine();
        System.out.print("해당 메뉴의 변경할 이름을 작성하시오. : ");
        String menuName = sc.nextLine();

        System.out.print("해당 메뉴의 변경할 가격을 작성하시오. : ");
        int menuPrice = sc.nextInt();

        Menu menu = new Menu(menuCode, menuName, menuPrice);

        updateMenu(menu);

    }
}
