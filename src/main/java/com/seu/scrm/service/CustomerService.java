package com.seu.scrm.Service;

import com.seu.scrm.Entity.Customer;

import java.util.List;

public interface CustomerService {
    void delete(String user_id);
    void  insert(Customer customer);
    void  insertOne(Customer customer);
    void  update(Customer customer);
    void  updateOpenId(Customer customer);
    Customer selectById(String user_id);
    List<Customer> select();
    Customer selectByOpenId(String open_id);
}
