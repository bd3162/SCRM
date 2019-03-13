package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Common_recom;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Common_recomMapper {
    @Delete("delete from common_recom where prod_asin=#{prod_asin}")
    void delete(@Param("prod_asin") String prod_asin);
    @Insert("insert into common_recom (prod_asin,update_time)values(#{common_recom.prod_recom},#{comon_recom.update_time})")
    void insert(@Param("common_recom") Common_recom common_recom);
    @Update("update common_recom set update_time=#{common_recom.upodate_time} where prod_asin=#{common_recom.prod_asin}")
    void update(@Param("common_recom") Common_recom common_recom);
    @Select("select * from common_recom where prod_asin=#{prod_asin}")
    Common_recom selectById( @Param("prod_asin") String prod_asin);
    @Select("select * from common_recom")
    List<Common_recom> select();
    @Select("select * from common_recom where update_time=(select Max(update_time) from common_recom)")
    List<Common_recom> selectByUpdateTime();
}
