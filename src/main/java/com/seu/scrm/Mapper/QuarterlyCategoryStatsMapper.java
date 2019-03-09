package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.QuarterlyCategoryStats;
import com.seu.scrm.Entity.QuarterlyCategoryStatsKey;
import com.seu.scrm.dto.CategorySales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuarterlyCategoryStatsMapper {
    int deleteByPrimaryKey(QuarterlyCategoryStatsKey key);

    int insert(QuarterlyCategoryStats record);

    int insertSelective(QuarterlyCategoryStats record);

    QuarterlyCategoryStats selectByPrimaryKey(QuarterlyCategoryStatsKey key);



    /**
     * 根据年份和季节获取每个季节里面销售量最大的几个类别
     * @param year
     * @param quarter
     * @param num
     * @return
     */
    List<CategorySales> selectListByYear(@Param("year") String year, @Param("quarter") int quarter, @Param("num") int num);


    /**
     * 根据年份和季节,类别获取当季度对应类别的销售数据
      * @param year
     * @param quarter
     * @param category
     * @param num
     * @return
     */
    List<CategorySales> selectSingleCategorySalesByYear( @Param("year") String year,
                                                         @Param("quarter") int quarter,
                                                         @Param("category") String category,
                                                         @Param("num") int num);

    int updateByPrimaryKeySelective(QuarterlyCategoryStats record);

    int updateByPrimaryKey(QuarterlyCategoryStats record);
}