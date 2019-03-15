package com.seu.scrm.Service;

import com.seu.scrm.Entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> selectByUserId(String user_id);
}
