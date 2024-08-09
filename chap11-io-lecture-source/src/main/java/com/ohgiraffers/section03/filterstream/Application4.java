package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {
        /* ObjectInputStream/ObjectOutputStream
        *  객체단위 입출력 보조 스트림 */

        MemberDTO[] members = {
                new MemberDTO("user01","pw1","홍길동",25, "남",95.7),
                new MemberDTO("user02","pw2","홍길등",26, "남",85.1),
                new MemberDTO("user03","pw3","홍길둥",27, "남",15.2),
                new MemberDTO("user04","pw4","홍길딩",28, "여",65.5)
        };
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("membet.txt"))){
//            oos.writeObject(members);
            for(MemberDTO member: members){
                oos.writeObject(member);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        MemberDTO[] inputMembers = new MemberDTO[members.length];
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("membet.txt"))){

            for(int i = 0; i < inputMembers.length; i++){
                inputMembers[i] = (MemberDTO) ois.readObject(); // 다운캐스팅 필요
            }

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(MemberDTO member: inputMembers){
            System.out.println(member);
        }
    }
}
