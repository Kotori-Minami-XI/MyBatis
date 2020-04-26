package com.Kotori.dao;

import com.Kotori.domain.Customer;

import java.util.List;

public interface CustomerDao {
    public Customer getCustomerById(Integer id);
    public List<Customer> getAllCustomer();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
}
