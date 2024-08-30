package com.ohgiraffers.section02.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            // 읽어올 대상 파일이 존재하지 않는 경우에 대해서 FileNotFoundException
            fis = new FileInputStream("testInputStream.txt");

            // fis.read() == -1 -- > 더 이상 읽어올 데이터가 없음.
//            int value;
//            while((value = fis.read()) != -1){
//                System.out.println((char)value);
//            }
            byte[] bar = new byte[100];
            fis.read(bar);
            System.out.println(Arrays.toString(bar));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fis != null) {
                try {
                    /* 자원 반납이 필요한 이유?
                    * 1. 장기간 실행 중인 프로그램에서 스트림을 닫지 않으면 누수 발생 가능성.
                    * 2. 버퍼의 잔류 데이터가 남은 상태에서 추가로 스트림을 사용하면 데드락 발생 가능성. */
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
