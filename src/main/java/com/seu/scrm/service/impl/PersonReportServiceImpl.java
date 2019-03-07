package com.seu.scrm.service.impl;

import com.seu.scrm.dto.*;
import com.seu.scrm.service.PersonReportService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by chenxiaosuo on 2019/3/7.
 */
@Service(value = "PersonReportService")
public class PersonReportServiceImpl implements PersonReportService{


    @Override
    public List<CategorySales> queryCategorySales(String userId, int num) {
        List<CategorySales> list = new ArrayList<CategorySales>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i=0; i < num; i++){
            CategorySales sales = new CategorySales();
            sales.setCategory( "Category_" + r.nextInt());
            sales.setSalesCount(r.nextInt());
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt());
            list.add(sales);
        }

        return list;
    }

    @Override
    public List<ProductSales> queryProductSales(String userId, int num) {
        List<ProductSales> list = new ArrayList<ProductSales>();


        //Todo
        //测试代码，需要替换。
        Random r=new Random();
        for(int i=0; i < num; i++){
            ProductSales sales = new ProductSales();
            sales.setProduct("Product_" + r.nextInt(10000));
            sales.setSalesCount(r.nextInt(1000) + 1);
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt(10000));
            list.add(sales);
        }

        return list;
    }

    @Override
    public List<BrandSales> queryBrandSales(String userId, int num) {
        List<BrandSales> list = new ArrayList<BrandSales>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random();
        for(int i=0; i < num; i++){
            BrandSales sales = new BrandSales();
            sales.setBrand("Brand_" + r.nextInt(10000));
            sales.setSalesCount(r.nextInt(1000) + 1);
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt(10000));
            list.add(sales);
        }

        return list;
    }

    @Override
    public List<PriceSales> queryPriceSales(String userId, int num) {
        List<PriceSales> list = new ArrayList<PriceSales>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random();
        for(int i=0; i < num; i++){
            PriceSales sales = new PriceSales();
            sales.setStartPrice(i * 1000);
            sales.setStartPrice((i+1)*1000);
            sales.setSalesCount(r.nextInt(1000));
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt(10000));
            list.add(sales);
        }

        return list;
    }

    @Override
    public List<Sales> queryTimeSales(String userId, int num) {
        List<Sales> list = new ArrayList<Sales>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i=0; i < num; i++){
            Sales sales = new Sales();
            sales.setSalesCount(r.nextInt(1000));
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt());
            list.add(sales);
        }

        return list;
    }
}
