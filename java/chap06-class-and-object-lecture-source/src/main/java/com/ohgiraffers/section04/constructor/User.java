package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {
    private String id;
    private String pw;
    private String name;
    private Date enrollDate;

    //생성자

    // 생성자 사용 목적
    /* 1. 인스턴스 생성 시점에 수행할 명령이 있을 때
    *  2. 매개변수 있는 생성자의 경우 매개변수로 전달 받은 값을 필드 초기화 할 때
    *  3. 작성한 생성자 외에는 인스턴스를 생성하는 방법을 제공하지 않는다는 의미
    *  ----> 인스턴스 생성 방법 제한 , 초기값 전달 강제화 */

    // 1. 기본 생성자 : 생성자가 0개일 때 컴파일러에 의해 자동으로 생성됨
    public User(){
        System.out.println("User created...");
    }
    // 2. 매개 변수 생성자 : 초기화 할 필드가 여러개인 경우 초기화 하고싶은 필드의 조합별로 생성자를 여러개 작성할 수 있다.
    public User(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
    public User(String id, String pw, String name, Date enrollDate){
//        this.id = id;
//        this.pw = pw;
        // this() : 동일 클래스 내의 다른 생성자 메소드를 호출하는 구문.
        // 리턴되어 돌아오지만 리턴 값은 존재하지 않으며 가장 첫 줄에 선언해야한다.
        this(id, pw);
        this.name = name;
        this.enrollDate = enrollDate;
        System.out.println("User 클래스의 id, pwd, name, enrollDate 초기화 생성자 호출...");
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

}
