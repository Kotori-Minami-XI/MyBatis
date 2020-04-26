package com.Kotori.mapper;

import com.Kotori.domain.Customer;

import java.util.List;

/***
 * 使用mapper的必须条件：
 * 1. namespace必须和Mapper接口类路径一致
 * 2. id必须和Mapper接口方法名一致
 * 3. parameterType必须和接口方法参数类型一致
 * 4. resultType必须和接口方法返回值类型一致
 */
public interface CustomerMapper {
    public Customer queryCustomerById(Integer id);
    public List<Customer> queryAllCustomer(Integer id);
    public void insertCustomer(Customer customer);
    public void updateCustomer(Customer customer);
}
