package com.seu.scrm.Service;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
   @Autowired
   private OrdersMapper ordersMapper;
    @Override
    //根据用户id查询订单
    public List<Orders> selectByUserId(String user_id) {
        return ordersMapper.selectByUserId(user_id);
    }
}
