package com.ohgiraffers.testapp.aggregate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class User implements Serializable {
    private int no;
    private String id;
    private String pw;
    private int age;
    private String[] hobby;
    private BloodType bloodType;


    public User(){

    }

    public User(int no, String id, String pw, int age, String[] hobby, BloodType bloodType) {
        this.no = no;
        this.id = id;
        this.pw = pw;
        this.age = age;
        this.hobby = hobby;
        this.bloodType = bloodType;
    }

    public User(String id, String pw, int age, String[] hobbies) {
        this.id = id;
        this.pw = pw;
        this.age = age;
        this.hobby = hobbies;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", bloodType=" + bloodType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return no == user.no && age == user.age && Objects.equals(id, user.id) && Objects.equals(pw, user.pw) && Objects.deepEquals(hobby, user.hobby) && bloodType == user.bloodType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, id, pw, age, Arrays.hashCode(hobby), bloodType);
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

}
