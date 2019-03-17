package com.seu.scrm.Service;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface OrdersService {
    List<Orders> selectByUserId(String user_id);
    List<Product>selectProductByOpenId(String open_id);
    List<Orders> selectOrdersByopenId( String open_id);
    List<Product>selectProductByAsinSet(Set<String> asinSet);
}
