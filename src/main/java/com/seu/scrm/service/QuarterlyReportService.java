package com.seu.scrm.service;


import com.seu.scrm.dto.CategorySales;
import com.seu.scrm.dto.ProductSales;
import com.seu.scrm.dto.Sales;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service(value = "QuarterlyReportService")
public class QuarterlyReportService {


    /**
     * 获取一年四个季度的总的销量数据
     * */
    public List<List<Sales>> queryTotalSales(String year, int num){

        List<List<Sales>> listList = new ArrayList<List<Sales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i = 0; i < 4; i++) {
            List<Sales> list = new ArrayList<Sales>();
            for (int j = 0; j < num; j++) {
                Sales sales = new Sales();
                sales.setSalesCount(r.nextInt(1000));
                sales.setSalesAmount(sales.getSalesCount() * r.nextInt(100));
                list.add(sales);
            }
            listList.add(list);
        }

        return listList;
    }


    /**
     * 获取一年四个季度里类别的销量数据
     *
     * */
    public List<List<CategorySales>> queryAllCategorySales(String year, int num){

        //listList里面是四个季度的类别销量数据，按照季度顺序从第一季度到第四季度
        List<List<CategorySales>> listList = new ArrayList<List<CategorySales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i = 0; i < 4; i++) {
            //list里面存放着每个季度的类别数据，按照销量从多到少排名
            List<CategorySales> list = new ArrayList<CategorySales>();
            for (int j = 0; j < num; j++) {
                CategorySales sales = new CategorySales();
                sales.setCategory("Category_"+"quarter" + i + "_No" + j + "_" + r.nextInt(1000));
                sales.setSalesCount(r.nextInt(1000));
                sales.setSalesAmount(sales.getSalesCount() * r.nextInt(100));
                list.add(sales);
            }
            listList.add(list);
        }

        return listList;
    }


    /**
     * 获取一年四个季度的产品的销量数据
     * */
    public List<List<ProductSales>> queryAllProductSales(String year, int num){

        //listList里面是四个季度的产品销量数据，按照季度顺序从第一季度到第四季度
        List<List<ProductSales>> listList = new ArrayList<List<ProductSales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i = 0; i < 4; i++) {
            //list里面存放着每个季度的产品数据，按照销量从多到少排名
            List<ProductSales> list = new ArrayList<ProductSales>();
            for (int j = 0; j < num; j++) {
                ProductSales sales = new ProductSales();
                sales.setProduct("Prouduct_"+"quarter" + i + "_No" + j + "_" + r.nextInt(1000));
                sales.setSalesCount(r.nextInt(1000));
                sales.setSalesAmount(sales.getSalesCount() * r.nextInt(100));
                list.add(sales);
            }
            listList.add(list);
        }

        return listList;
    }


    /**
     * 获取一年四个季度的某一个类别的统计数据
     * */
    public List<List<CategorySales>> queryCategorySales(String year, String category, int num){

        List<List<CategorySales>> listList = new ArrayList<List<CategorySales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i = 0; i < 4; i++) {
            List<CategorySales> list = new ArrayList<CategorySales>();
            for (int j = 0; j < num; j++) {
                CategorySales sales = new CategorySales();
                sales.setCategory("Category_"+"quarter" + i + "_No" + j + "_" + r.nextInt(1000));
                sales.setSalesCount(r.nextInt(1000));
                sales.setSalesAmount(sales.getSalesCount() * r.nextInt(100));
                list.add(sales);
            }
            listList.add(list);
        }

        return listList;
    }


    /**
     * 获取一年四个季度的某个类别下产品的销量数据
     * */
    public List<List<ProductSales>> queryCategoryProductSales(String year, String category, int num){

        //listList里面是四个季度的产品销量数据，按照季度顺序从第一季度到第四季度
        List<List<ProductSales>> listList = new ArrayList<List<ProductSales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i = 0; i < 4; i++) {
            //list里面存放着每个季度的产品数据，按照销量从多到少排名
            List<ProductSales> list = new ArrayList<ProductSales>();
            for (int j = 0; j < num; j++) {
                ProductSales sales = new ProductSales();
                sales.setProduct("Prouduct_"+"quarter" + i + "_No" + j + "_" + r.nextInt(1000));
                sales.setSalesCount(r.nextInt(1000));
                sales.setSalesAmount(sales.getSalesCount() * r.nextInt(100));
                list.add(sales);
            }
            listList.add(list);
        }

        return listList;
    }


    /**
     * 获取一年四个季度的某个产品的销量数据
     * */
    public List<List<ProductSales>> queryProductSales(String year, String product, int num){

        //listList里面是四个季度的产品销量数据，按照季度顺序从第一季度到第四季度
        List<List<ProductSales>> listList = new ArrayList<List<ProductSales>>();

        //Todo
        //测试代码，需要替换。
        Random r=new Random(10000);
        for(int i = 0; i < 4; i++) {
            //list里面存放着每个季度的产品数据，按照销量从多到少排名
            List<ProductSales> list = new ArrayList<ProductSales>();
            for (int j = 0; j < num; j++) {
                ProductSales sales = new ProductSales();
                sales.setProduct("Prouduct_"+"quarter" + i + "_No" + j + "_" + r.nextInt(1000));
                sales.setSalesCount(r.nextInt(1000));
                sales.setSalesAmount(sales.getSalesCount() * r.nextInt(100));
                list.add(sales);
            }
            listList.add(list);
        }

        return listList;
    }


}
