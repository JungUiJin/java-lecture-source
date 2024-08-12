package com.ohgiraffers.section01.map;

import java.io.*;
import java.util.Properties;

public class Application3 {
    public static void main(String[] args) {
        /* 제네릭 선언이 아닌 String,String이 기본 */

        Properties prop = new Properties();


        prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:@127.0.0.1:1521:xe");
        prop.setProperty("user", "student");
        prop.setProperty("password", "student");

        System.out.println(prop);

        try {
            prop.store(new FileOutputStream("driver.dat"), "jdbc driver");
            prop.store(new FileWriter("driver.txt"), "jdbc driver");
            prop.storeToXML(new FileOutputStream("driver.xml"), "jdbc driver");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties prop2 = new Properties();
        Properties prop3 = new Properties();
        try {
            prop2.load(new FileInputStream("driver.dat"));
            prop3.load(new FileReader("driver.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(prop2.getProperty("driver"));
        System.out.println(prop2.getProperty("url"));
        System.out.println(prop2.getProperty("user"));
        System.out.println(prop2.getProperty("password"));
    }
}
