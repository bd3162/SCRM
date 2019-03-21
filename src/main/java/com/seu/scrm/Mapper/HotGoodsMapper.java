package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotGoodsMapper {

    @Select("SELECT  * from product,common_recom where common_recom.prod_asin=product.asin ")
    List<Product> select();

    @Select(" select * from customer where open_id =#{open_id}")
        Orders selectById(@Param("open_id") String open_id);

    @Select("select * from product where asin in (SELECT prod_asin from personal_recom WHERE " +
            "personal_recom.user_id = (SELECT user_id from customer where open_id= #{open_id}))")
         List<Product> select1(@Param("open_id") String open_id);
}