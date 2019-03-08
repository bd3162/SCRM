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
    public List<List<CategorySales>> queryCategorySales(String userId, int num) {
        List<CategorySales> list = new ArrayList<CategorySales>();
        List<List<CategorySales>> listList = new ArrayList<List<CategorySales>>();

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
        listList.add(list);

        return listList;
    }

    @Override
    public List<List<ProductSales>> queryProductSales(String userId, int num) {
        List<ProductSales> list = new ArrayList<ProductSales>();
        List<List<ProductSales>> listList = new ArrayList<List<ProductSales>>();

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
        listList.add(list);

        return listList;
    }

    @Override
    public List<List<BrandSales>> queryBrandSales(String userId, int num) {
        List<BrandSales> list = new ArrayList<BrandSales>();
        List<List<BrandSales>> listList = new ArrayList<List<BrandSales>>();
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
        listList.add(list);

        return listList;
    }

    @Override
    public List<List<PriceSales>> queryPriceSales(String userId, int num) {
        List<PriceSales> list = new ArrayList<PriceSales>();
        List<List<PriceSales>> listList = new ArrayList<List<PriceSales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random();
        for(int i=0; i < num; i++){
            PriceSales sales = new PriceSales();
            sales.setStartPrice(i * 1000);
            sales.setEndPrice((i+1)*1000);
            sales.setSalesCount(r.nextInt(1000));
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt(10000));
            list.add(sales);
        }

        listList.add(list);

        return listList;
    }

    @Override
    public List<List<Sales>> queryTimeSales(String userId, int num) {
        List<Sales> list = new ArrayList<Sales>();
        List<List<Sales>> listList = new ArrayList<List<Sales>>();


        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i=0; i < num; i++){
            Sales sales = new Sales();
            sales.setSalesCount(r.nextInt(1000));
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt());
            list.add(sales);
        }

        listList.add(list);

        return listList;
    }
}
