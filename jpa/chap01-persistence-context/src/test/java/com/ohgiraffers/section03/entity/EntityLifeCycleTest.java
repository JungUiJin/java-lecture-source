package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.annotations.Parameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EntityLifeCycleTest {

    private EntityLifeCycle entityLifeCycle;

    @BeforeEach
    void setUp() {
        this.entityLifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void testTransient(int menuCode){
        // when
        Menu foundMenu = entityLifeCycle.findMenuByMenuCode(menuCode);
        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        // then

        EntityManager entityManager = entityLifeCycle.getEntityManagerInstance();
        assertTrue(entityManager.contains(foundMenu)); // foundMenu는 영속성 컨텍스트에서 관리 되는 영속 상태의 객체
        assertFalse(entityManager.contains(newMenu)); // newMenu는 영속성 컨텍스트에서 관리 되지 않는 비영속 상태의 객체
    }

    @DisplayName("다른 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2,3})
    void testManagedOtherEntityManager(int menuCode){
        // when
        Menu menu1 = entityLifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = entityLifeCycle.findMenuByMenuCode(menuCode);

        // then
        assertNotEquals(menu1, menu2);

    }
    @DisplayName("같은 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2,3})
    void testManagedSameEntityManager(int menuCode){
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        // when
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);

        // then
        assertEquals(menu1, menu2);

    }

    @DisplayName("반 영속성 테스트")
    @ParameterizedTest
    @CsvSource({"11,1000","12,1000"})
    void testDetachedEntity(int menuCode, int menuPrice){
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // detach : 특정 엔터티만 준영속 상태로 만든다.
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);

        // flush : 영속성 컨텍스트의 상태를 DB로 내보낸다. 단 commit 하지 않은 상태이므로 rollback 가능하다.
        entityManager.flush();

        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("준영속화 detach 후 다시 영속화 테스트")
    @ParameterizedTest
    @CsvSource({"11,1000","12,1000"})
    void testDetachedMerge(int menuCode, int menuPrice){
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Menu foundMenu = entityManager.find(Menu.class, menuCode);


        // detach : 특정 엔터티만 준영속 상태로 만든다.
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);

        // merge : 파라미터로 넘어온 준영속 엔터티 객체의 식별자 값으로 1차 캐시에서 엔터티 객체를 조회한다.
        // 없으면 DB에서 조회하여 1차 캐시에 저장한다.
        // 조회한 영속 엔터티 객체에 준영속 상태의 엔터티 객체 값을 병합한 뒤 영속 엔터티 객체를 반환한다.
        // 혹은 조회할 수 없는 데이터라면 새로 생성해서 병합한다.

        // flush : 영속성 컨텍스트의 상태를 DB로 내보낸다. 단 commit 하지 않은 상태이므로 rollback 가능하다.
        entityManager.merge(foundMenu);
        entityManager.flush();

        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("detach 후 merge한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource({"11, 하양 민트초코죽","12, 까만 딸기탕후루"})
    void testMergedUpdate(int menuCode, String menuName){
        // given
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);

        // when
        foundMenu.setMenuName(menuName);
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);

        // merge 는 반영속성 객체의 상태를 영속성 객체에 업데이트 하는 것.
        entityManager.merge(foundMenu);

        // then
        assertEquals(menuName, refoundMenu.getMenuName());
    }

    @DisplayName("detach 후 merge 한 데이터 save 테스트")
    @Test
    void testMergeSave(){
        // given
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, 20);
        entityManager.detach(foundMenu);

        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스크림");
        foundMenu.setMenuCode(999);

        entityManager.merge(foundMenu);
        entityTransaction.commit();

        assertEquals("치약맛 초코 아이스크림", entityManager.find(Menu.class, 999).getMenuName());
    }

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2,3})
    void testClearPersistenceContext(int menuCode){
        // given
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // when
        // clear: 영속성 컨텍스트를 초기화 한다. --> 영속성 컨텍스트 내의 모든 엔터티는 준영속화 된다.
        entityManager.clear();

        // then
        Menu expectedMenu = entityManager.find(Menu.class, menuCode);
        assertNotEquals(expectedMenu, foundMenu);
    }

    @DisplayName("준영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2,3})
    void testClosePersistenceContext(int menuCode){
        // given
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // when
        // close : 영속성 컨텍스트 종료된다. -> 영속성 컨텍스트 내의 모든 엔터티는 준영속화 된다.
        entityManager.close();

        // then
        assertThrows(
                IllegalStateException.class,
                () -> entityManager.find(Menu.class, menuCode)
        );
    }

    @DisplayName("영속성 엔터티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void testRemoveEntity(int menuCode){
        //given
        EntityManager entityManager = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        entityTransaction.begin();

        // remove : 엔터티를 영속성 컨텍스트 및 데이터 베이스에서 삭제한다.
        // 단, 트랜잭션을 제어하지 않으면 데이터 베이스에 영구 반영 되지는 않는다.
        entityManager.remove(foundMenu);
        entityManager.flush();

        Menu refoundMenu = entityManager.find(Menu.class, menuCode);
        assertNull(refoundMenu);
        entityTransaction.rollback();

    }









}