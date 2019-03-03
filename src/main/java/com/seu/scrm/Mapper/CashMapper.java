package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CashMapper {
    /**
     * 根据商品asin找到商品
     * @param asin
     * @return product
     */
    @Select("select * from product where asin = #{asin}")
    List<product> findProdByID(@Param("asin") String asin);
}
