package com.Kotori.dao;

import com.Kotori.domain.Customer;
import com.Kotori.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    @Override
    public Customer getCustomerById(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", 1);
        sqlSession.close();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> list = sqlSession.selectList("queryAllCustomer");
        sqlSession.close();
        return list;
    }

    @Override
    public void addCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.insert("insertCustomer", customer);
        // 当对数据库进行增删改的时候，需要手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.selectOne("updateCustomer", customer);
        // 当对数据库进行增删改的时候，需要手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
