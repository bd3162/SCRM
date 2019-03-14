package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Activity;
import com.seu.scrm.Entity.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerMapper {
    @Insert("insert into customer(user_id,face_id,open_id,memb_points)values(#{customer.user_id},#{customer.face_id},#{customer.open_id},#{customer.memb_points})")
    void insert(@Param("customer") Customer customer);
    @Insert("insert into customer(user_id,face_id)values(#{customer.user_id},#{customer.face_id})")
    void insertOne(@Param("customer") Customer customer);
    @Update("update customer set face_id=#{customer.face_id},open_id=#{customer.open_id},memb_points=#{customer.memb_points} where user_id=#{customer.user_id}")
    void update(@Param("customer") Customer customer);
    @Update("update customer set open_id=#{customer.open_id} where user_id=#{customer.user_id}")
    void updateOpenId(@Param("customer") Customer customer);
    @Delete("delete from customer where user_id =#{user_id}")
    void delete(@Param("user_id") String user_id);
    @Select(" select *  from customer where user_id =#{user_id}")
   Customer selectById(@Param("user_id") String  user_id);
    @Select("select * from customer")
    List<Customer> select();
    //selectByOpenId
    @Select(" select *  from customer where open_id =#{open_id}")
    Customer selectByOpenId(@Param("open_id") String  open_id);
}
