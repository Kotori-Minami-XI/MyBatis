package com.Kotori.test;

import com.Kotori.domain.Customer;
import com.Kotori.domain.Order;
import com.Kotori.mapper.CustomerMapper;
import com.Kotori.mapper.OrderMapper;
import com.Kotori.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCustomerMapper {
    @Test
    public void testDeleteCustomer() {
        SqlSession sqlSession = MybatisUtils.openSession();

        // 先打破外键的关系
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.updateRelationCustomer(5);

        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        customerMapper.deleteCustomer(5);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testQueryAllCustomer() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> list = mapper.queryAllCustomer();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void testQueryAllCustomerByStep() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> list = mapper.queryAllCustomerByStep();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void testqueryCustomerById() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.queryCustomerById(1);
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void testVagueQueryByName() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> list = mapper.vagueQueryByName("K");
        for (Customer customer : list) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void testInsertCustomer() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_phone("123231");
        customer.setCust_name("Nico");
        customer.setEmail("4321456@qq.com");
        customer.setCust_profession("idol");

        // 添加customer并获取customer的主键
        mapper.insertCustomer(customer);
        System.out.println(customer);

        sqlSession.commit();
        sqlSession.close();
    }
}
