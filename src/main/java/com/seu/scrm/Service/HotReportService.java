package com.seu.scrm.service;

import com.seu.scrm.Entity.HotCategoryStats;
import com.seu.scrm.Mapper.HotBrandStatsMapper;
import com.seu.scrm.Mapper.HotCategoryStatsMapper;
import com.seu.scrm.Mapper.HotProductStatsMapper;
import com.seu.scrm.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HotCategoryStatsMapper hotCategoryStatsMapper;
    @Autowired
    private HotProductStatsMapper hotProductStatsMapper;
    @Autowired
    private HotBrandStatsMapper hotBrandStatsMapper;

    /**
     *
     * @param period
     * @param num
     * @return
     */
    public List<List<CategorySales>> queryCategorySales(int period, int num){
        List<List<CategorySales>> listList = new ArrayList<List<CategorySales>>();

        List<CategorySales> list  = hotCategoryStatsMapper.selectListByPeriod(period, num);
        listList.add(list);

        return listList;
    }

    /**
     *
     * @param period
     * @param num
     * @return
     */
    public List<List<ProductSales>> queryProductSales(int period, int num){
        List<List<ProductSales>> listList = new ArrayList<List<ProductSales>>();

        List<ProductSales> list  = hotProductStatsMapper.selectListByPeriod(period, num);
        listList.add(list);

        return listList;
    }

    /**
     *
     * @param period
     * @param num
     * @return
     */
    public List<List<BrandSales>> queryBrandSales(int period, int num){
        List<List<BrandSales>> listList = new ArrayList<List<BrandSales>>();

        List<BrandSales> list = hotBrandStatsMapper.selectListByPeriod(period, num);

        listList.add(list);

        return listList;
    }

}
