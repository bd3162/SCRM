package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrdersMapper {
    @Select("select * from orders where user_id=#{user_id}")
    List<Orders> selectByUserId(@Param("user_id") String user_id);
    /*@Select("with t1 as (select user_id from customer  where open_id=#{open_id}),\n" +
            "t2 as (select prod_asin from orders where user_id in (select user_id from t1))\n" +
            "select * from product where asin in (select prod_asin from t2)")
    List<Product>selectProductByOpenId(@Param("open_id") String open_id);*/
    @Select("select * from orders where user_id in " +
            "(select user_id from customer  where open_id=#{open_id})")
    List<Orders> selectOrdersByopenId(@Param("open_id") String open_id);
    //
    @Select("<script>" +
            "select * from product where asin in " +
            "<foreach collection ='asinSet' item='asin' open='(' separator=',' close=')'>" +
            "#{asin}" +
            "</foreach>"+
            "</script>")
    List<Product>selectProductByAsinSet(@Param("asinSet") Set<String> asinSet);
    @Select("with t1 as (select user_id from customer  where open_id=#{open_id}), \n" +
            "            t2 as (select prod_asin, num from orders where user_id in (select user_id from t1))\n" +
            "            select asin, title,imUrl,price,num,num*price from product,t2 where asin in (select prod_asin from t2) and t2.prod_asin=asin")
    List<Product>selectProductByOpenId(@Param("open_id") String open_id);

   // @Select("select * from product where asin =#{asin})")

    //Product selectProductByAsin(@Param("asin") String asin);
}
