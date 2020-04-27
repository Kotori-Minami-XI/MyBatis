package com.Kotori.test;

import com.Kotori.domain.Customer;
import com.Kotori.domain.Order;
import com.Kotori.mapper.CustomerMapper;
import com.Kotori.mapper.OrderMapper;
import com.Kotori.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class TestOrderMapper {
    @Test
    public void testDeleteAllOrder() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        mapper.deleteAllOrder();

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        for (int i=0; i<20; i++) {
            mapper.insertOrder(randomGenerateOrder(i, 3));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testLeftJoinQuery() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = mapper.leftJoinQuery();
        for (Order order : list){
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void testStepQuery() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.getOrderWithOrderId(206);
        System.out.println(order);
        sqlSession.close();
    }

    @Test
    public void testUpdateCustId() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        mapper.updateCustId(206,2);
        sqlSession.commit();
        sqlSession.close();
    }


    public Order randomGenerateOrder(Integer index, Integer maxCustId) {
        Random random = new Random();

        Order order = new Order();
        order.setOrder_name("Cargo" + index.toString());

        Integer order_num = (random.nextInt(9999) + 1);
        order.setOrder_num(order_num.toString());

        order.setCust_id(random.nextInt(maxCustId) + 1);
        return order;
    }

}
