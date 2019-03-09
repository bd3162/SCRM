package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.HotProductStats;
import com.seu.scrm.Entity.HotProductStatsKey;
import com.seu.scrm.dto.ProductSales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotProductStatsMapper {
    int deleteByPrimaryKey(HotProductStatsKey key);

    int insert(HotProductStats record);

    int insertSelective(HotProductStats record);

    HotProductStats selectByPrimaryKey(HotProductStatsKey key);

    /**
     * 根据period获取最近时间的热点商品,获取的数量为num个
     * @param period
     * @param num
     * @return
     */
    List<ProductSales> selectListByPeriod(@Param("period") int period, @Param("num") int num);

    int updateByPrimaryKeySelective(HotProductStats record);

    int updateByPrimaryKey(HotProductStats record);
}