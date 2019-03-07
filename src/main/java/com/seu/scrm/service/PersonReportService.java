package com.seu.scrm.service;

import com.seu.scrm.dto.*;

import java.util.List;

/**
 * Created by chenxiaosuo on 2019/3/7.
 * 根据用户ID处理统计交易数据
 */
public interface PersonReportService {

    List<CategorySales> queryCategorySales(String userId, int num);

    List<ProductSales> queryProductSales(String userId, int num);

    List<BrandSales> queryBrandSales(String userId, int num);

    List<PriceSales> queryPriceSales(String userId, int num);

    List<Sales> queryTimeSales(String userId, int num);


}
