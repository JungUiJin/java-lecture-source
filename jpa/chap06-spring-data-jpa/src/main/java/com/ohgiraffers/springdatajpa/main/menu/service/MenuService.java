package com.ohgiraffers.springdatajpa.main.menu.service;

import com.ohgiraffers.springdatajpa.main.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.main.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.main.menu.entity.Category;
import com.ohgiraffers.springdatajpa.main.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.main.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.main.menu.repository.MenuRepository;
import org.modelmapper.ModelMapper;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    /* Entity to DTO 작업이 필요하다.
    *  1. 수동 매핑 메소드 작성(toEntity, fromEntity, toDTO, fromDTO)
    *  2. 자동 매핑 라이브러리 사용 */

    /* 1. findById */
    public MenuDTO findMenuByMenuCode(int menuCode){

        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 2. findAll(Sort) */
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());
        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* 3. findAll(Pageable) */
    public Page<MenuDTO> findMenuList(Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending()
        );

        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {

//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);
        return menuList.stream()
                .map(menu -> modelMapper.map(menu,MenuDTO.class))
                .toList();
    }

    public List<CategoryDTO> findAllCategory() {

        List<Category> categoryList = categoryRepository.findAllCategory();
        return categoryList.stream()
                .map(category -> modelMapper.map(category,CategoryDTO.class))
                .toList();
    }

    @Transactional
    public void registMenu(MenuDTO menuDTO) {

        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }


    /* 수정기능 */
    @Transactional
    public void modifyMenu(MenuDTO menuDTO) {
        Menu foundMenu = menuRepository.findById(menuDTO.getMenuCode()).orElseThrow(IllegalArgumentException::new);

        // setter 사용 지양, 기능에 맞는 메소드를 별도로 정의해서 사용하기.
        foundMenu.modifyMenuName(menuDTO.getMenuName());

    }

    @Transactional
    public void deleteMenu(MenuDTO menuDTO) {
        menuRepository.deleteById(menuDTO.getMenuCode());
    }
}
