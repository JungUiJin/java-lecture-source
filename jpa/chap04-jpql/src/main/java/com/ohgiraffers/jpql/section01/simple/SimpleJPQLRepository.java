package com.ohgiraffers.jpql.section01.simple;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery(){
        String jqpl = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 2";
        TypedQuery<String> query = entityManager.createQuery(jqpl, String.class);
        String resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    public Object selectSingleMenuByQuery(){
        String jqpl = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 2";
        Query query = entityManager.createQuery(jqpl);
        Object resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    public Menu selectSingleRowByTypedQuery(){
        String jqpl = "SELECT m FROM Section01Menu as m WHERE m.menuCode = 2";
        TypedQuery<Menu> query = entityManager.createQuery(jqpl, Menu.class);
        Menu resultMenu = query.getSingleResult();
        return resultMenu;
    }
    public List<Menu> selectMultipleRowByTypedQuery(){
        String jqpl = "SELECT m FROM Section01Menu as m";
        TypedQuery<Menu> query = entityManager.createQuery(jqpl, Menu.class);
        List<Menu> resultMenuList = query.getResultList();
        return resultMenuList;
    }
    public List<Integer> selectUsingDistinct(){
        String jqpl = "SELECT DISTINCT m.categoryCode FROM Section01Menu as m";
        TypedQuery<Integer> query = entityManager.createQuery(jqpl, Integer.class);
        List<Integer> resultMenuList = query.getResultList();
        return resultMenuList;
    }
    public List<Menu> selectUsingIn(){
        String jqpl = "SELECT m FROM Section01Menu as m WHERE m.categoryCode IN (4, 5, 6)";
        TypedQuery<Menu> query = entityManager.createQuery(jqpl, Menu.class);
        List<Menu> resultMenuList = query.getResultList();
        return resultMenuList;
    }
    public List<Menu> selectUsingLike(){
        String jqpl = "SELECT m FROM Section01Menu as m WHERE m.menuName LIKE CONCAT('%', '김치', '%')";
        TypedQuery<Menu> query = entityManager.createQuery(jqpl, Menu.class);
        List<Menu> resultMenuList = query.getResultList();
        return resultMenuList;
    }
}
