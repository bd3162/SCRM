package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.customer;
import com.seu.scrm.Entity.product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CashMapper {
    /**
     * @Description: 根据商品asin找到商品
     * @param asin
     * @return product
     */
    @Select("select * from product where asin = #{asin}")
    product findProdByID(@Param("asin") String asin);

    /**
     * @Description: 插入用户订单
     * @Param: user_id prod_sin num
     * @Return: int (用于判断是否插入成功)
     * @Author: karin
     */

    @Insert("insert into orders(user_id,prod_asin,num)values(#{user_id},#{prod_asin},${num})")
    int addOrder(@Param("user_id") String user_id, @Param("prod_asin") String prod_id, @Param("num") int num);

    /**
     * @Description: 查询用户当前积分
     * @Param: user_id
     * @Return: menb_points
     * @Author: karin
     */
    @Select("select * from customer where user_id = #{user_id}")
    customer findCustomerByID(@Param("user_id") String user_id);

    /**
     * @Description: 修改会员用户的积分
     * @Param:
     * @Return:
     * @Author: karin
     */
    @Update("update customer set memb_points = ${memb_points} where user_id = #{user_id}")
    int updatePoints(@Param("user_id") String user_id, @Param("memb_points") int memb_points);

}
