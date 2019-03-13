package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {
    @Select("select * from orders where user_id=#{user_id}")
    List<Orders> selectByUserId(@Param("user_id") String user_id);
}
