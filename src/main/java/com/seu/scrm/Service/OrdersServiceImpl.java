package com.seu.scrm.Service;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrdersServiceImpl implements OrdersService {
   @Autowired
   private OrdersMapper ordersMapper;
   @Autowired
   public RedisTemplate<Object,Object> redisTemplate;
   public RedisTemplate<String,String> redisTemplate1;
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
       /* RedisSerializer redisSerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
*/
        RedisSerializer stringSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();
         redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
         redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);

//        redisTemplate.setHashValueSerializer(redisSerializer);
        //this.redisTemplate=redisTemplate;
        System.out.println(redisTemplate.opsForValue().get(open_id));
        List<Orders> ordersList = (List<Orders>) (redisTemplate.opsForValue().get(open_id));
        if (null == ordersList) {
            ordersList = ordersMapper.selectOrdersByopenId(open_id);
            redisTemplate.opsForValue().set(open_id, ordersList);
        }
        return ordersList;

        // return ordersMapper.selectOrdersByopenId(open_id);
    }

    @Override
    public List<Product> selectProductByAsinSet(Set<String> asinSet) {
        return ordersMapper.selectProductByAsinSet(asinSet);
    }
}
