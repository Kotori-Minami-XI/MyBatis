package com.Kotori.mapper;

import com.Kotori.domain.Customer;
import com.Kotori.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    public void insertOrder(Order order);
    public List<Order> leftJoinQuery();
    public void deleteAllOrder();
    public Order getOrderWithOrderId(Integer id);
    public Order getOrderWithCustId(Integer id);
    public void updateCustId(@Param("orderId") Integer orderId, @Param("custId") Integer custId);
    public void updateRelationCustomer(Integer cust_id);
}
