package com.ohgiraffers.section02.javaconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;



    public MenuController() {

        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null && !menuList.isEmpty()) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selecMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.selectByMenuCode(menuCode);
        if(menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectByMenuCode");
        }
    }

    public void registMenu(Map<String, String> parameter) {
        MenuDTO menu = new MenuDTO();
        menu.setMenuPrice(Integer.parseInt(parameter.get("menuPrice")));
        menu.setMenuName(parameter.get("menuName"));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if(menuService.registMenu(menu)){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");

        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(Integer.parseInt(parameter.get("menuCode")));
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.parseInt(parameter.get("menuPrice")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if(menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        if(menuService.deleteMenu(menuCode)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("selectByMenuCode");
        }
    }
}
