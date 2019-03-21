package com.seu.scrm.Controller.Order;


import com.seu.scrm.Entity.Product;
import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Service.order.HotGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/HotGoods")
public class OrdersController {
    @Autowired
    private HotGoodsService hotGoodsService;
    @Autowired
    public RedisTemplate<Object, Object> redisTemplate;

    @RequestMapping(value="/selectById" ,method = RequestMethod.GET)
    public  Map<String,Object> selectOrdersById(String id){
        List<Orders> ordersList = (List<Orders>) redisTemplate.opsForValue().get(id);
        if(ordersList==null) {
            List<Product> listProduct =hotGoodsService.selectHotGoods();
            Map<String,Object> map=new HashMap<>();
            map.put("热点商品",listProduct);
            //System.out.println();
            return  map ;
        }
        else{
            List<Product> listProduct =hotGoodsService.selectRecommend(id);
            Map<String,Object> map=new HashMap<>();
            map.put("个人推荐商品",listProduct);
            return map;
        }

    }
}