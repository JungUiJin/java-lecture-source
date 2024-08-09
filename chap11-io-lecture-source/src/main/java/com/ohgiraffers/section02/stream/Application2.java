package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {
        /* FileReader 를 이해하고 사용할 수 있다.
        *  FileInputStream 과 사용법은 거의 동일 하나 1byte 단위가 아니라 character 단위로 읽어온다. */

        /* try with resource 문으로 작성 */
        try(FileReader fr = new FileReader("testReader.txt")){

//            int value;
//            while((value=fr.read())!= -1){
//                System.out.print((char)value);
//            }

            char[] carr = new char[100];
            fr.read(carr);
            for(char c : carr) System.out.print(c);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
