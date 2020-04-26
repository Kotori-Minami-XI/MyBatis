package com.Kotori.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    public static final SqlSessionFactory sqlSessionFactory;
    static {
        InputStream resourceAsStream = null;
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

}
