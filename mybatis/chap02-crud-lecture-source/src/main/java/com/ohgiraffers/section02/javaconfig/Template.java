package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;

public class Template {

    /* SqlSessionFactory : 애플리케이션 실행하는 동한 존재해야하며 여러 차례 다시 빌드하지 않는 것이 좋은 형태이다.
     * => singleton (오로지 1개의 객체만 생성) 하는 패턴을 이용하는 것이 가장 좋다.
     * */
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "root";
    private static String PASSWORD = "root";

    private static SqlSessionFactory sqlSessionFactory;

    /* 한 번의 요청 당 1개의 SqlSession 객체가 필요하므로 필요 시 호출한 메소드 */
    public static SqlSession getSqlSession() {


        if(sqlSessionFactory == null) {
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD)
            );
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(MenuMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }


        /* SqlSession : Thread에 안전하지 않고 공유 되지 않아야 하므로 요청 시 마다 생성한다. */
        return sqlSessionFactory.openSession(false);
    }
}