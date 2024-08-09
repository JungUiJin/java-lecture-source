package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {
        /* DataInputStream/OutputStream */

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("score.txt"))) {

            dos.writeUTF("홍길동");
            dos.writeInt(90);
            dos.writeChar('A');

            dos.writeUTF("홍길등");
            dos.writeInt(80);
            dos.writeChar('B');

            dos.writeUTF("홍길둥");
            dos.writeInt(70);
            dos.writeChar('C');

        }catch (IOException e) {

            System.out.println(e.getMessage());

        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("score.txt"))) {
            /* 파일에 기록한 순서 대로 읽어오지 않는 경우 에러가 발생하거나 의미 없는 데이터를 얽어오게 된다. */
            while(true){
                System.out.println(dis.readUTF());
                System.out.println(dis.readInt());
                System.out.println(dis.readChar());
            }
            // read자료형 메소드는 파일에서 더 이상 읽어올 값이 없는 경우 EOFException 발생
        }catch (EOFException e){
            System.out.println("파일 읽기가 완료되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
