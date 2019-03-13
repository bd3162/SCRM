package com.seu.scrm.Service;


import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;


import java.util.List;

public interface HotGoodsService {




  //
    public Orders selectOrdersById(String open_id) ;
    public List<Product> selectHotGoods() ;

    public List<Product> selectRecommend(String open_id) ;

}