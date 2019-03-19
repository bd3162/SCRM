package com.seu.scrm.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    public RedisTemplate<Object, Object> redisTemplate;
    public RedisTemplate<Object, Object> redisTemplate1;

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

        List<Orders> ordersList = (List<Orders>) redisTemplate.opsForValue().get(open_id);
        if (null == ordersList) {
            ordersList = ordersMapper.selectOrdersByopenId(open_id);
            redisTemplate.opsForValue().set(open_id, ordersList);
        }
        return ordersList;

       // return ordersMapper.selectOrdersByopenId(open_id);
    }

    @Override
    public List<Product> selectProductByAsinSet(Set<String> asinSet) {
//        List<Product> productList = null;
//        for (String s : asinSet) {
//
//            Product product = (Product) redisTemplate.opsForValue().get(s);
//            if (null == product) {
//                if (productList == null)
//                    productList = ordersMapper.selectProductByAsinSet(asinSet);
//
//                for (Product product1 : productList) {
//                    if (product1.getAsin() == s)
//                        redisTemplate.opsForValue().set(s, product1);
//
//                }
//            }
//
//
//        }
//        return productList;
//    }

        return ordersMapper.selectProductByAsinSet(asinSet);
    }
}


