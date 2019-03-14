package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Activity;
import com.seu.scrm.Entity.Personal_recom;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Personal_recomMapper {



    @Insert("insert into personal_recom(user_id,prod_asin,rank,update_time)values(#{personal_recom.user_id},#{personal_recom.prod_asin},#{personal_recom.rank},#{personal_recom.update_time})")
    void insert(@Param("personal_recom") Personal_recom personal_recom);
    @Update("update personal_recom set prod_asin=#{personal_recom.prod_asin},rank=#{personal_recom.rank},update_time=#{personal_recom.update_time} where user_id=#{personal_recom.user_id}")
    void update(@Param("personal_recom") Personal_recom personal_recom);
    @Delete("delete from personal_recom where user_id=#{user_id}")
    void delete(@Param("user_id") int user_id);
    @Select("select * from personal_recom where user_id=#{user_id}")
    Personal_recom selectById(@Param("user_id") int user_id);
    @Select("select * from personal_recom")
    List<Personal_recom> select();
    //个性化查询 根据user_id 和最大update_time
    @Select("select * from personal_recom where user_id=#{user_id} and update_time=(select Max(update_time) from personal_recom)")
    List<Personal_recom> selectByUserIdAndUpdateTime(@Param("user_id")String user_id);

}
