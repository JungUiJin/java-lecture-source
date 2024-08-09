package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {
        File file = new File("test.txt");

        try {
            // 최초 실행 시 생성되어 true, 파일이 존재할 경우 새롭게 만들지 않아 false;
            boolean createSuccess = file.createNewFile();
            System.out.println("createSuccess: " + createSuccess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("file.length: " + file.length());
        System.out.println("file.getPath(): " + file.getPath());
        System.out.println("file.getParent() : " + file.getParent());
        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("file.getName(): " + file.getName());

        boolean deleteSuccess = file.delete();
        System.out.println("deleteSuccess: " + deleteSuccess);
    }
}
