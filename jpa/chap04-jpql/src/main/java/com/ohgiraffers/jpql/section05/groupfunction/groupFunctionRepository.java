package com.ohgiraffers.jpql.section05.groupfunction;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class groupFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Long countMenuOfCategory(int categoryCode){
        String jpql = "select count(m.menuCode) from Section05Menu m where m.categoryCode=:categoryCode";
        long countOfMenu = entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();

        return countOfMenu;
    }

    public Long sumMenuPriceOfCategory(int categoryCode){
        String jpql
                = "SELECT SUM(m.menuPrice) FROM Section05Menu m "
                + "WHERE m.categoryCode = :categoryCode";
        /* count 외의 그룹 함수는 결과 값이 없을 경우 null이 반환 되기 때문에 기본 자료형으로 다룰 경우 문제 발생 */
        Long sumMenuPrice = entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();

        return sumMenuPrice;
    }

    public List<Object[]> selectByGroupByHaving(long minPrice) {
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice)" +
                " FROM Section05Menu m" +
                " GROUP BY m.categoryCode" +
                " HAVING SUM(m.menuPrice) >= :minPrice";

        List<Object[]> sumPriceOfCategoryList
                =  entityManager.createQuery(jpql)
                .setParameter("minPrice", minPrice)
                .getResultList();

        return sumPriceOfCategoryList;
    }
}
