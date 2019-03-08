package com.seu.scrm.service;

import com.seu.scrm.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenxiaosuo on 2019/3/7.
 * 热点信息获取服务
 */

@Service(value = "HotReportService")
public class HotReportService {

    public List<List<CategorySales>> queryCategorySales(int period, int num){
        List<CategorySales> list = new ArrayList<CategorySales>();
        List<List<CategorySales>> listList = new ArrayList<List<CategorySales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i=0; i < num; i++){
            CategorySales sales = new CategorySales();
            sales.setCategory( "Category_" + r.nextInt(10000));
            sales.setSalesCount(r.nextInt(1000));
            sales.setSalesAmount(sales.getSalesCount() * r.nextInt(10000));
            list.add(sales);
        }
        listList.add(list);

        return listList;
    }

    public List<List<ProductSales>> queryProductSales(int period, int num){
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

    public List<List<BrandSales>> queryBrandSales(int period, int num){
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

}
