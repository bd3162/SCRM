package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.HotCategoryStats;
import com.seu.scrm.Entity.HotCategoryStatsKey;
import com.seu.scrm.dto.CategorySales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotCategoryStatsMapper {
    int deleteByPrimaryKey(HotCategoryStatsKey key);

    int insert(HotCategoryStats record);

    int insertSelective(HotCategoryStats record);


    HotCategoryStats selectByPrimaryKey(HotCategoryStatsKey key);

    /**
     * 根据period获取最近时间的热点类别,获取的数量为num个
     * @param period
     * @param num
     * @return List<HotCategoryStats>
     */
    List<CategorySales> selectListByPeriod(@Param("period") int period, @Param("num") int num);

    int updateByPrimaryKeySelective(HotCategoryStats record);

    int updateByPrimaryKey(HotCategoryStats record);
}