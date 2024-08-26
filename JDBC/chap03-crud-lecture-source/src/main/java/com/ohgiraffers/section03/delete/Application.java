package com.ohgiraffers.section03.delete;

import java.util.Scanner;

import static com.ohgiraffers.section03.delete.MenuService.deleteMenu;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 메뉴의 고유 번호를 입력하시오. :");

        int menuId = sc.nextInt();

        deleteMenu(menuId);
    }
}
