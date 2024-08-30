package com.ohgiraffers.section07.statickeyword;

public class FinalFieldTest {
    /* final 키워드를 사욜할 수 있는 위치
    * 1. 지역변수 : 초기화 이후 값 변경 불가
    * 2. 매개변수 : 호출 시 전달한 값 변경 불가
    * 3. 인스턴스변수 : 인스턴스 생성 후 초기화 이후에 값 변경 불가
    * 4. 클래스변수 : 프로그램 시작 이후 값 변경 불가
    * 5. non-static 메소드 : 메소드 재작성(overriding) 불가
    * 6. static 메소드 : 메소드 재작성(overriding) 불가
    * 7. 클래스 :
    * */


    /* non-static field에 final 사용
    *  초기 인스턴스 생성 시 기본 값 0이 필드에 들어가게 되는데 초기화 이후 값 변경이 불가하므로
    *  선언과 동시에 초기화가 필요하다. */
    private final int NON_STATIC_NuM = 1;
    private final String NON_STATIC_NAME;
    public FinalFieldTest(String nonStaticName) {
        this.NON_STATIC_NAME = nonStaticName;
    }

    /* static field에 final 키워드 사용
     * 생성자를 이용한 초기화는 불가능하다.
     * 초기화 되지 않은 상태로 선언 된 것과 동일하다.
     * final과 static의 순서는 무관하다.*/
    private static final int STATIC_NUM_NM;

    /* 초기화 블럭을 통해 초기화 할 수 있다. */
    static{
        STATIC_NUM_NM = 1;
    }
}
