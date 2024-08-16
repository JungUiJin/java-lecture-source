package section02.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTests {

    @Disabled // 이 어노테이션이 붙은 테스트틑 무시하고 실행된다.
    @Test
    void testIgnore(){
        System.out.println("testIgnore");
    }

    @Disabled
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testTimeout(){
        try {
            Thread.sleep(900);
            System.out.println("testTimeout");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(1)
    void testFirst(){
        System.out.println("testFirst");
    }
    @Test
    @Order(3)
    void testSecond(){
        System.out.println("testSecond");
    }
    @Test
    @Order(2)
    void testThird(){
        System.out.println("testThird");
    }

    @RepeatedTest(10)
    void testRepetition(){
        System.out.println("testRepetition");
    }
}
