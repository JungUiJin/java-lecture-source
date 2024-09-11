package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {
    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴를 조회하는 기능 */
    public Menu findMenuByMenuCode(int menuCode){
        entityManager = EntityManagerGenerator.getEntityManager();
        return entityManager.find(Menu.class, menuCode);
    }

    /* 2. 새로운 메뉴 저장 */
    public Long saveAndReturnAllCount(Menu newMenu){
        entityManager = EntityManagerGenerator.getEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(newMenu);
        entityTransaction.commit();

        return getCount(entityManager);
    }

    /* 3. 메뉴 이름 수정 */
    public Menu modifyMenuName(int menuCode, String menuName){
        entityManager = EntityManagerGenerator.getEntityManager();
        Menu findMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        findMenu.setMenuName(menuName);

        entityTransaction.commit();

        return findMenu;

    }

    /* 4. 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public Long removeAndReturnAllCount(int menuCode){
        entityManager = EntityManagerGenerator.getEntityManager();

        Menu menu = findMenuByMenuCode(menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(menu);

        entityTransaction.commit();
        return getCount(entityManager);
    }

    private Long getCount(EntityManager entityManager){
        return entityManager // JPQL 문법 -> 별도 챕터에서 다룸.
                .createQuery("SELECT count(*) FROM Section02Menu", Long.class)
                .getSingleResult();
    }



}
