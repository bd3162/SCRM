package com.seu.scrm.Service;/*
 * @description: 收银员业务层
 * @author: karin
 * */

import com.seu.scrm.Entity.customer;
import com.seu.scrm.Entity.product;
import com.seu.scrm.Mapper.CashMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CashierService {

    @Autowired
    private CashMapper cashMapper;

    public  List<product> findProdByID(@RequestParam("asin") String asin){
        List<product> products=cashMapper.findProdByID(asin);
        return products;
    }

    public int addOrder(@RequestParam("user_id") String user_id, @RequestParam("prod_asin") String prod_asin){
        int value = this.cashMapper.addOrder(user_id,prod_asin);
         return value;
    }

    public customer findCustomerByID(@RequestParam("user_id") String user_id) {
          customer _customer = cashMapper.findCustomerByID(user_id);
          return _customer;
    }

    public int updatePoints(@RequestParam("user_id") String user_id, @RequestParam("memb_points") int memb_points){
        return  this.cashMapper.updatePoints(user_id,memb_points);
    }

}
