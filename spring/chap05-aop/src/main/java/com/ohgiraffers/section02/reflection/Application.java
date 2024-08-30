package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {

        // .class 문법을 이용하여 Class 타입의 인스턴스를 생성
        Class class1 = Account.class;
        System.out.println("class1: " + class1);

        // Object 클래스의 getClass 메소드를 이용해서 Class 타입 인스턴스 생성 가능
        Class class2 = new Account().getClass();
        System.out.println("class2: " + class2);


        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            Class class4 = Class.forName("[D");
            Class class5 = double[].class;
            System.out.println("class3: " + class3);
            System.out.println("class4: " + class4);
            System.out.println("class5: " + class5);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        double d = 1.0;
//        Class class6 = d.getClass();
        Class class6 = Double.TYPE;
        System.out.println("class6: " + class6);

        Class superClass = class1.getSuperclass();
        System.out.println("superClass: " + superClass);

        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field: " + field);
            System.out.println("type: " + field.getType());
            System.out.println("name: " + field.getName());
        }

        Constructor[] constructors = class1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("name : " + constructor.getName());
            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("param: " + param.getTypeName());
            }
        }

        try {
            Account acc = (Account) constructors[0].newInstance("20","110-234-567890","1234",10000);
            System.out.println(acc.getBalance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Method[] methods = class1.getMethods();
        Method getBalance = null;

        for(Method method : methods){
            System.out.print(Modifier.toString(method.getModifiers())+" ");
            System.out.print(method.getReturnType().getSimpleName()+" ");
            System.out.println(method.getName());
            if("getBalance".equals(method.getName())) getBalance = method;
        }

        try {
            System.out.println(getBalance.invoke(constructors[2].newInstance()));
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
}
