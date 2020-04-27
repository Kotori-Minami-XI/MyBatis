package com.Kotori.mapper;

import com.Kotori.domain.Order;

import java.util.List;

public interface OrderMapper {
    public void insertOrder(Order order);
    public List<Order> leftJoinQuery();
    public void deleteAllOrder();
}
