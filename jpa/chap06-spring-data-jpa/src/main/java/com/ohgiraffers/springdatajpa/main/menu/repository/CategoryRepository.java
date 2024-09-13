package com.ohgiraffers.springdatajpa.main.menu.repository;

import com.ohgiraffers.springdatajpa.main.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(
//            value = "SELECT c FROM Category c ORDER BY  c.categoryCode",
            value = "SELECT category_code, category_name, ref_category_code " +
                    "FROM tbl_category " +
                    "ORDER BY category_code",
            nativeQuery = true // JPQL이면 생략 가능(default가 false)
    )
    List<Category> findAllCategory();
}
