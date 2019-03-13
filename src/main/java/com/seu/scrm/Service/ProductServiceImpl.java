package com.seu.scrm.Service;

import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product selectProductById(String asin) {
        return productMapper.selectProductById(asin);
    }
}
