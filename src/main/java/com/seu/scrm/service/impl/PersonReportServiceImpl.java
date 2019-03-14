package com.seu.scrm.service.impl;

import com.seu.scrm.Mapper.PersonStatsMapper;
import com.seu.scrm.dto.*;
import com.seu.scrm.service.PersonReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by chenxiaosuo on 2019/3/7.
 */
@Service(value = "PersonReportService")
public class PersonReportServiceImpl implements PersonReportService{


    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(PersonReportServiceImpl.class);
    @Autowired
    private PersonStatsMapper personStatsMapper;

    @Override
    public List<List<CategorySales>> queryCategorySales(String userId, int num) {
        List<CategorySales> list = new ArrayList<CategorySales>();
        List<List<CategorySales>> listList = new ArrayList<List<CategorySales>>();

        list = personStatsMapper.selectCategorySalesById(userId, num);

        listList.add(list);

        return listList;
    }

    @Override
    public List<List<ProductSales>> queryProductSales(String userId, int num) {
        List<ProductSales> list = new ArrayList<ProductSales>();
        List<List<ProductSales>> listList = new ArrayList<List<ProductSales>>();

        logger.info("userId: " +userId + " num:"+ num);
        list = personStatsMapper.selectProductSalesById(userId, num);
        listList.add(list);

        return listList;
    }

    @Override
    public List<List<BrandSales>> queryBrandSales(String userId, int num) {
        List<BrandSales> list = new ArrayList<BrandSales>();
        List<List<BrandSales>> listList = new ArrayList<List<BrandSales>>();

        list = personStatsMapper.selectBrandSalesById(userId, num);
        listList.add(list);

        return listList;
    }

    @Override
    public List<List<PriceSales>> queryPriceSales(String userId, int num) {
        List<PriceSales> list = new ArrayList<PriceSales>();
        List<List<PriceSales>> listList = new ArrayList<List<PriceSales>>();
        Integer[] startPriceList = new Integer[]{0, 1, 50, 200, 500};
        Integer[] endPriceList = new Integer[]{0, 50, 200, 500, 1000};

        list = personStatsMapper.selectPriceSalesById(userId, num);
        for(int i=0; i<list.size();i++){
            list.get(i).setStartPrice(startPriceList[i]);
            list.get(i).setEndPrice(endPriceList[i]);
        }
        listList.add(list);

        return listList;
    }

    @Override
    public List<List<Sales>> queryTimeSales(String userId, int num) {
        List<Sales> list = new ArrayList<Sales>();
        List<List<Sales>> listList = new ArrayList<List<Sales>>();


        list = personStatsMapper.selectTimeSalesById(userId, num);
        listList.add(list);

        return listList;
    }
}
