package com.seu.scrm.Service;

import com.seu.scrm.Entity.Customer;
import com.seu.scrm.Mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements  CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public void delete(String user_id) {
        customerMapper.delete(user_id);
    }

    @Override
    public void insert(Customer customer) {
         customerMapper.insert(customer);
    }
    //只添加user_id 和face_id
    @Override
    public void insertOne(Customer customer) {
         customerMapper.insertOne(customer);
    }

    @Override
    public void update(Customer customer) {
         customerMapper.update(customer);
    }

    @Override
    public void updateOpenId(Customer customer) {
         customerMapper.updateOpenId(customer);
    }

    @Override
    public Customer selectById(String user_id) {
        return customerMapper.selectById(user_id);
    }

    @Override
    public List<Customer> select() {
        return customerMapper.select();
    }

    @Override
    public Customer selectByOpenId(String open_id) {
        return customerMapper.selectByOpenId(open_id);
    }
}
