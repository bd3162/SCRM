package com.seu.scrm.Controller;


import com.seu.scrm.Entity.Product;
import com.seu.scrm.Entity.Orders;
import com.seu.scrm.service.order.HotGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/HotGoods")
public class OrdersController {
    @Autowired
    private HotGoodsService hotGoodsService;

    @RequestMapping(value="/selectById" ,method = RequestMethod.GET)
    public  Map<String,Object> selectOrdersById(String id){
        Orders orders=hotGoodsService.selectOrdersById(id);
        if(orders==null) {
            List<Product> list =hotGoodsService.selectHotGoods();
            Map<String,Object> map=new HashMap<>();
            map.put("list",list);
            return  map ;
        }
        else{
            List<Product> list =hotGoodsService.selectRecommend(id);
            Map<String,Object> map=new HashMap<>();
            map.put("list",list);
            return map;
        }

    }
}