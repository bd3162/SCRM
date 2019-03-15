package com.seu.scrm.Service;


import com.seu.scrm.Entity.QuarterlyCategoryStats;
import com.seu.scrm.Entity.QuarterlyCategoryStatsKey;
import com.seu.scrm.Entity.QuarterlyProductStatsKey;
import com.seu.scrm.Mapper.QuarterlyCategoryStatsMapper;
import com.seu.scrm.Mapper.QuarterlyProductStatsMapper;
import com.seu.scrm.Mapper.QuarterlyTotalStatsMapper;
import com.seu.scrm.dto.CategorySales;
import com.seu.scrm.dto.ProductSales;
import com.seu.scrm.dto.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service(value = "QuarterlyReportService")
public class QuarterlyReportService {

    @Autowired
    QuarterlyCategoryStatsMapper quarterlyCategoryStatsMapper;
    @Autowired
    QuarterlyProductStatsMapper quarterlyProductStatsMapper;
    @Autowired
    QuarterlyTotalStatsMapper quarterlyTotalStatsMapper;

    /**
     * 获取一年四个季度的总的销量数据
     * */
    public List<List<Sales>> queryTotalSales(String year, int num){

        List<List<Sales>> listList = new ArrayList<List<Sales>>();

        //四个季度分别查询；最后合并成总表
        //优化？？
        for(int i = 1; i < 5; i++) {
            //list里面存放着每个季度的销售数据，按照销量从多到少排名
            List<Sales> list = quarterlyTotalStatsMapper.selectListByYear(year, i, num);
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

        //四个季度分别查询；最后合并成总表
        //优化？？
        for(int i = 1; i < 5; i++) {
            //list里面存放着每个季度的类别数据，按照销量从多到少排名
            List<CategorySales> list = quarterlyCategoryStatsMapper.selectListByYear(year, i, num);
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

        //四个季度分别查询；最后合并成总表
        //优化？？
        for(int i = 1; i < 5; i++) {
            //list里面存放着每个季度的产品数据，按照销量从多到少排名
            List<ProductSales> list = quarterlyProductStatsMapper.selectListByYear(year, i, num);
            listList.add(list);
        }

        return listList;

    }


    /**
     * 获取一年四个季度的某一个类别的统计数据
     * */
    public List<List<CategorySales>> queryCategorySales(String year, String category){

        List<List<CategorySales>> listList = new ArrayList<List<CategorySales>>();

        //四个季度分别查询；最后合并成总表
        //优化？？
        for(int i = 1; i < 5; i++) {
            //list里面存放着每个季度的产品数据，按照销量从多到少排名
            List<CategorySales> list = quarterlyCategoryStatsMapper
                    .selectSingleCategorySalesByYear(year, i, category);
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

        //四个季度分别查询；最后合并成总表
        //优化？？
        for(int i = 1; i < 5; i++) {
            //list里面存放着每个季度的产品数据，按照销量从多到少排名
            List<ProductSales> list = quarterlyProductStatsMapper.selectCategoryProductListByYear(year, i, category, num);
            listList.add(list);
        }
        return listList;
    }


    /**
     * 获取一年四个季度的某个产品的销量数据
     * */
    public List<List<ProductSales>> queryProductSales(String year, String product){

        List<List<ProductSales>> listList = new ArrayList<List<ProductSales>>();

        //四个季度分别查询；最后合并成总表
        //优化？？
        for(int i = 1; i < 5; i++) {
            //list里面存放着每个季度的产品数据，按照销量从多到少排名
            List<ProductSales> list = quarterlyProductStatsMapper
                    .selectSingleProductSalesByYear(year, i, product);
            listList.add(list);
        }

        return listList;
    }


}
