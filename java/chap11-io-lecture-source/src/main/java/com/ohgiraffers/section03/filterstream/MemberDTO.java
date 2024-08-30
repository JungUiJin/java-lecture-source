package com.ohgiraffers.section03.filterstream;

/* 객체 입출력 처리를 위해서는 반드시 직렬화 처리를 해야한다.
*  직렬화 대상 클래스에 Serializable 인터페이스만 구현하면 직렬화가 필요한 경우 데이터 직렬화 처리가 된다.  */
public class MemberDTO implements java.io.Serializable {
    private String id;
    private String pw;
    private String name;
    private int age;
    private String gender;
    private double point;

    public MemberDTO() {

    }

    public MemberDTO(String id, String pw, String name, int age, String gender, double point) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.point = point;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", point=" + point +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
