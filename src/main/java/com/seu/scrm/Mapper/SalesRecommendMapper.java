package com.seu.scrm.Mapper;


import com.seu.scrm.dto.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenxiaosuo on 2019/3/20.
 */
public interface SalesRecommendMapper {

    /**
     * 查询指定用户的推荐信息
     * @param userId
     * @return
     */
    List<ProductInfo> queryPersonalProductList(@Param("userId") String userId);

    /**
     * 获取通用的推荐信息
     * @return
     */
    List<ProductInfo> queryCommonProductList();
}
