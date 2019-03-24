package com.seu.scrm.Service.order;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.HotGoodsMapper;
import com.seu.scrm.Service.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HotGoodsServiceImpl implements HotGoodsService{
    @Autowired
    private HotGoodsMapper hotGoodsMapper;
    @Autowired
    public RedisTemplate<Object, Object> redisTemplate1;



    @Override
    public List<Product> selectHotGoods()  {
        return hotGoodsMapper.select();
    }

    @Override
    public Orders selectOrdersById(String order_id) {
        return  hotGoodsMapper.selectById(order_id);
    }

    @Override
    public List<Product> selectRecommend( String open_id)  {

        RedisSerializer stringSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();
        redisTemplate1.setKeySerializer(stringSerializer);
        redisTemplate1.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate1.setHashKeySerializer(stringSerializer);
        redisTemplate1.setHashValueSerializer(genericJackson2JsonRedisSerializer);

        String usid=open_id+"1";
        List<Product> productList = (List<Product>) redisTemplate1.opsForValue().get(usid);

        if (null == productList) {
            productList = hotGoodsMapper.select1(open_id);
            redisTemplate1.opsForValue().set(usid, productList);

        }

        return productList;

        // return ordersMapper.selectOrdersByopenId(open_id);
    }

}