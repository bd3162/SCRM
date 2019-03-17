package com.seu.scrm.Service;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrdersServiceImpl implements OrdersService {
   @Autowired
   private OrdersMapper ordersMapper;
    @Override
    //根据用户id查询订单
    public List<Orders> selectByUserId(String user_id) {
        return ordersMapper.selectByUserId(user_id);
    }

    @Override
    public List<Product> selectProductByOpenId(String open_id) {
        return ordersMapper.selectProductByOpenId(open_id);
    }

    @Override
    public List<Orders> selectOrdersByopenId(String open_id) {
        return ordersMapper.selectOrdersByopenId(open_id);
    }

    @Override
    public List<Product> selectProductByAsinSet(Set<String> asinSet) {
        return ordersMapper.selectProductByAsinSet(asinSet);
    }
}
