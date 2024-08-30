package com.ohgiraffers.section02.encapsulation.problem3;

public class Monster {
    // 몬스터 클래스에 변경 사항 발생
    // name -> kinds로 변경
//    String name;
    String kinds;
    int hp;
    public void setInfo(String info){
        this.kinds = info;
    }
    public String getInfo(){
        return "몬드터의 이름은 " + this.kinds + "입니다.";
    }

}
