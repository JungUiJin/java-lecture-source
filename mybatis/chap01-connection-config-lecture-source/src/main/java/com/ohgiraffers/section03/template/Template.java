package com.ohgiraffers.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    /* 어플리케이션 실행하는 동안 존재해야 하며 여러 차례 다시 빌드하지 않는 것이 좋은 형태이다.
    *  ==> singleton(오로지 1개의 객체만 생성) 하는 패턴을 이용하는 것이 가장 좋다. */
    private static SqlSessionFactory SqlSessionFactory;

    /* 한 번의 요청 당 1개의 SqlSession 객체가 필요하므로 필요 시 호출한 메소드*/
    public static SqlSession getSqlSession() {

        if(SqlSessionFactory == null) {
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return SqlSessionFactory.openSession(false);

    }

}
