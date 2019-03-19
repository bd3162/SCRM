package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.QuarterlyTotalStats;
import com.seu.scrm.Entity.QuarterlyTotalStatsKey;
import com.seu.scrm.dto.Sales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuarterlyTotalStatsMapper {
    int deleteByPrimaryKey(QuarterlyTotalStatsKey key);

    int insert(QuarterlyTotalStats record);

    int insertSelective(QuarterlyTotalStats record);

    QuarterlyTotalStats selectByPrimaryKey(QuarterlyTotalStatsKey key);

    /**
     * 根据年份和季度获取销量数据，条数限定为num个
     * @param year
     * @param quarter
     * @param num
     * @return
     */
    List<Sales> selectListByYear(@Param("year") String year, @Param("quarter") int quarter, @Param("num") int num);

    int updateByPrimaryKeySelective(QuarterlyTotalStats record);

    int updateByPrimaryKey(QuarterlyTotalStats record);
}