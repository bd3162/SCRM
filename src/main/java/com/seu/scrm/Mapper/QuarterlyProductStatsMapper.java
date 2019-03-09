package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.QuarterlyProductStats;
import com.seu.scrm.Entity.QuarterlyProductStatsKey;
import com.seu.scrm.dto.ProductSales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuarterlyProductStatsMapper {
    int deleteByPrimaryKey(QuarterlyProductStatsKey key);

    int insert(QuarterlyProductStats record);

    int insertSelective(QuarterlyProductStats record);

    QuarterlyProductStats selectByPrimaryKey(QuarterlyProductStatsKey key);

    /**
     * 根据年份和季度获取销量最大的num个产品
     * @param year
     * @param quarter
     * @param num
     * @return
     */
    List<ProductSales> selectListByYear(@Param("year") String year, @Param("quarter") int quarter, @Param("num") int num);

    /**
     * 根据季度信息，获取选定类别下卖的最好的若干个产品的销售信息
     * @param year
     * @param quarter
     * @param category
     * @param num
     * @return
     */
    List<ProductSales> selectCategoryProductListByYear(@Param("year") String year,
                                                       @Param("quarter") int quarter,
                                                       @Param("category") String category,
                                                       @Param("num") int num);

    /**
     * 根据年份和季节,获取指定产品的销售数据
     * @param year
     * @param quarter
     * @param product
     * @param num
     * @return
     */
    List<ProductSales> selectSingleProductSalesByYear(@Param("year") String year,
                                                      @Param("quarter") int quarter,
                                                      @Param("product") String product,
                                                      @Param("num") int num);

    int updateByPrimaryKeySelective(QuarterlyProductStats record);

    int updateByPrimaryKey(QuarterlyProductStats record);
}