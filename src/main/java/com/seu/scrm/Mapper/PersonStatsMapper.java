package com.seu.scrm.Mapper;

import com.seu.scrm.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonStatsMapper {

    /**
     * 获取单个用户的购买类别统计信息
     * @param userId
     * @param num
     * @return
     */
    List<CategorySales> selectCategorySalesById(@Param("userId") String userId, @Param("num") int num);

    /**
     * 获取单个用户的购买品牌统计信息
     * @param userId
     * @param num
     * @return
     */
    List<BrandSales> selectBrandSalesById(@Param("userId") String userId, @Param("num") int num);


    /**
     * 获取单个用户的购买产品统计信息
     * @param userId
     * @param num
     * @return
     */
    List<ProductSales> selectProductSalesById(@Param("userId") String userId, @Param("num") int num);


    /**
     * 获取单个用户的不同的小时的产品统计信息
     * @param userId
     * @param num
     * @return
     */
    List<Sales> selectTimeSalesById(@Param("userId") String userId, @Param("num") int num);


    /**
     * 获取单个用户的不同的价格区间的产品统计信息
     * @param userId
     * @param num
     * @return
     */
    List<PriceSales> selectPriceSalesById(@Param("userId") String userId, @Param("num") int num);

}
