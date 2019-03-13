package com.seu.scrm.Mapper;


import com.seu.scrm.Entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    @Select("select * from product where asin=#{asin}")
    Product selectProductById(@Param("asin") String  asin);
}
