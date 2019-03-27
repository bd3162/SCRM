package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Customer;
import com.seu.scrm.Entity.Product;

import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashMapper {
    /**
     * @Description: 根据商品asin找到商品
     * @param asin
     * @return product
     */

    @Select("select * from product where asin = #{asin}")
    Product findProdByID(@Param("asin") String asin);

    /**
     * @Description: 插入用户订单
     * @Param: user_id prod_sin num
     * @Return: boolean (用于判断是否插入成功)
     * @Author: karin
     */

    @Insert("insert into orders(user_id,prod_asin,num,unix_time)values(#{user_id},#{prod_asin},${num},${unix_time})")
    boolean addOrder(@Param("user_id") String user_id, @Param("prod_asin") String prod_id, @Param("num") int num,@Param("unix_time") int unix_time);

    /**
     * @Description: 插入新用户
     * @Param: user_id
     * @Return: boolean (用于判断是否插入成功)
     * @Author: karin
     */

    @Insert("insert into customer(user_id)values(#{user_id})")
    boolean addUser(@Param("user_id") String user_id);

    /**
     * @Description: 根据user_id查找用户的信息
     * @Param: user_id
     * @Return: customer
     * @Author: karin
     */
    @Select("select * from customer where user_id = #{user_id}")
    Customer findCustomerByID(@Param("user_id") String user_id);

    /**
     * @Description: 修改会员用户的积分
     * @Param: user_id memb_points
     * @Return:
     * @Author: karin
     */
    @Update("update customer set memb_points = ${memb_points} where user_id = #{user_id}")
    boolean updatePoints(@Param("user_id") String user_id, @Param("memb_points") int memb_points);

    /**
     * @Description: 给用户加验证码
     * @Param: user_id verif
     * @Return: 
     * @Author: karin
     */
    @Update("update customer set verif = #{verif} where user_id = #{user_id}")
    boolean updateVerif(@Param("user_id") String user_id, @Param("verif") String verif);

    /**
     * @Description: 根据verif查找用户的信息
     * @Param: verif
     * @Return: customer
     * @Author: karin
     */
    @Select("select * from customer where verif = #{verif}")
    Customer findCustomerByVerif(@Param("verif") String verif);

    /**
     * @Description: 给用户加open_id等
     * @Param: open_id verif
     * @Return: 
     * @Author: karin
     */
    @Update("update customer set open_id = #{open_id},city=#{city},gender=${gender},avatarUrl=#{avatarUrl} where verif = #{verif}")
    boolean updateOpen_id(@Param("open_id") String open_id,@Param("city") String city,@Param("gender") int gender,@Param("avatarUrl") String avatarUrl, @Param("verif") String verif);

}
