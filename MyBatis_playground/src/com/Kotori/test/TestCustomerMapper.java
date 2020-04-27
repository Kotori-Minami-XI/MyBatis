package com.Kotori.test;

import com.Kotori.domain.Customer;
import com.Kotori.mapper.CustomerMapper;
import com.Kotori.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCustomerMapper {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.queryCustomerById(1);
        System.out.println(customer);
        sqlSession.close();
    }
}
