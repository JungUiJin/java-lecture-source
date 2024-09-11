package com.ohgiraffers.associationmapping.section01.manytoone;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManyToOneService {

    private ManyToOneRepository manyToOneRepository;

    public ManyToOneService (ManyToOneRepository ManyToOneRepository) {
        this.manyToOneRepository = ManyToOneRepository;
    }

    public Menu findMenu(int menuCode) {
        return manyToOneRepository.find(menuCode);
    }

    public String findCategoryNameByJpql(int menuCode) {
        return manyToOneRepository.findCategoryName(menuCode);
    }

    @Transactional
    public void registMenu(MenuDTO newMenu) {
        Menu menu = new Menu(
                newMenu.getMenuCode(),
                newMenu.getMenuName(),
                newMenu.getMenuPrice(),
                new Category(
                        newMenu.getCategory().getCategoryCode(),
                        newMenu.getCategory().getCategoryName(),
                        newMenu.getCategory().getRefCategoryCode()
                ),
                newMenu.getOrderableStatus()
        );
        manyToOneRepository.regist(menu);
    }

}
