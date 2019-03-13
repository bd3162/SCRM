package com.seu.scrm.Mapper;

import com.seu.scrm.Entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashMapper {
    /**
     * 根据商品asin找到商品
     * @param asin
     * @return product
     */
    @Select("select * from product where asin = #{asin}")
    List<Product> findProdByID(@Param("asin") String asin);
}
