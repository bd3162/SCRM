package com.seu.scrm.Mapper;

import java.util.List;

import com.seu.scrm.Entity.Activity;

import com.seu.scrm.Entity.Personal_recom;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapper {

    @Insert("insert into activity(id,activ_title,activ_img,activ_desc,start_date,end_date)values(#{activity.id},#{activity.activ_title},#{activity.activ_img},#{activity.activ_desc},#{activity.start_date},#{activity.end_date})")
    boolean insert(@Param("activity") Activity activity);
    @Update("update activity set activ_title=#{activity.activ_title},activ_img=#{activity.activ_img},activ_desc=#{activity.activ_desc},start_date=#{activity.start_date},end_date=#{activity.end_date} where id =#{activity.id}")
    boolean update(@Param("activity") Activity activity);
    @Delete("delete from activity where id =#{id}")
    void delete(@Param("id") int id);
    @Select(" select id,activ_title,activ_img,activ_desc,start_date,end_date  from activity where id =#{id}")
    Activity selectById(@Param("id") int id);
    @Select("select * from activity")
    List<Activity> select();


}