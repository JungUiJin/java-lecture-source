package section01.lifecycle;


import org.junit.jupiter.api.*;

/* 테스트 메소드의 실행 전 후에 도작하는 어노테이션을 사용할 수 있다. */
public class LifeCycleAnnotationTests {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All");
    }
    @AfterEach
    void afterEach(){
        System.out.println("After Each");
    }

    @Test
    void test1(){
        System.out.println("test1");
    }
    @Test
    void test2(){
        System.out.println("test2");
    }
}
