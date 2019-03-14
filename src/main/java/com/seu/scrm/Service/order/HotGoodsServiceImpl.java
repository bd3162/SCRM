package com.seu.scrm.Service.order;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.HotGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotGoodsServiceImpl implements HotGoodsService{
    @Autowired
    private HotGoodsMapper hotGoodsMapper;

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
        return hotGoodsMapper.select1(open_id);
    }

}