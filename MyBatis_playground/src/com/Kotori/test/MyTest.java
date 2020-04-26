package com.Kotori.test;

import com.Kotori.domain.Customer;
import com.Kotori.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void testQuery1() throws IOException {
        SqlSession sqlSession = MybatisUtils.openSession();

        Customer customer = sqlSession.selectOne("queryCustomerById", 1);
        System.out.println(customer);

        sqlSession.close();
    }

    @Test
    public void testQuery2() throws IOException {
        SqlSession sqlSession = MybatisUtils.openSession();

        List<Customer> list = sqlSession.selectList("queryAllCustomer");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testQuery3() throws IOException {
        SqlSession sqlSession = MybatisUtils.openSession();

        List<Customer> list = sqlSession.selectList("vagueQueryByName", "K"); //采用$符号则必须要用${value}
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testInsert1() throws IOException {
        Customer customer = new Customer();
        customer.setCust_name("Sara");
        customer.setCust_phone("1234121");
        customer.setCust_profession("teacher");
        customer.setEmail("312321@qq.com");

        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.insert("insertCustomer", customer);

        // 当对数据库进行增删改的时候，需要手动提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdate1() throws IOException {
        SqlSession sqlSession = MybatisUtils.openSession();

        Customer customer = sqlSession.selectOne("queryCustomerById", 3);
        customer.setCust_name("123");
        customer.setCust_phone("aaaaaaaa");

        sqlSession.selectOne("updateCustomer", customer);
        // 当对数据库进行增删改的时候，需要手动提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDelete1() throws IOException {
        SqlSession sqlSession = MybatisUtils.openSession();

        sqlSession.selectOne("deleteCustomer", 4);
        // 当对数据库进行增删改的时候，需要手动提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
