package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.HotBrandStats;
import com.seu.scrm.Entity.HotBrandStatsKey;
import com.seu.scrm.dto.BrandSales;
import com.seu.scrm.dto.ProductSales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotBrandStatsMapper {
    int deleteByPrimaryKey(HotBrandStatsKey key);

    int insert(HotBrandStats record);

    int insertSelective(HotBrandStats record);

    HotBrandStats selectByPrimaryKey(HotBrandStatsKey key);

    /**
     *  获取最近period 天的热点品牌列表
     * @param period
     * @param num
     * @return
     */
    List<BrandSales> selectListByPeriod(@Param("period") int period, @Param("num") int num);

    int updateByPrimaryKeySelective(HotBrandStats record);

    int updateByPrimaryKey(HotBrandStats record);
}