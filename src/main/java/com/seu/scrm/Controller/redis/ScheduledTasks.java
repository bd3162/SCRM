package com.seu.scrm.Controller.redis;


import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.HotGoodsMapper;
import com.seu.scrm.Mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ScheduledTasks {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    private HotGoodsMapper hotGoodsMapper;

    @Autowired(required = false)
    private OrdersMapper ordersMapper;


    @Scheduled(cron = "0 * 8-18 * * ?")
    public void CacheDate() {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
       // System.out.println("测试程序");
        //Integer prefixLength = "posts_views::posts_views_id_".length();
        Set<String> keySet = redisTemplate.keys("oy????????????????????????");
        //System.out.println(keySet);
        //List<Product> productList = null;
        //List<Orders> ordersList = null;
        for (String key : keySet) {
            //System.out.println(key);
            List<Orders> ordersList = ordersMapper.selectOrdersByopenId(key);
                redisTemplate.opsForValue().set(key, ordersList);

            List<Product> productList = hotGoodsMapper.select1(key);
            String key1=key+"1";
                redisTemplate.opsForValue().set(key1, productList);
            }

        }

    }

