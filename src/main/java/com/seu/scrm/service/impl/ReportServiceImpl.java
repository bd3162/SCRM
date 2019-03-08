package com.seu.scrm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seu.scrm.dto.*;
import com.seu.scrm.service.HotReportService;
import com.seu.scrm.service.PersonReportService;
import com.seu.scrm.service.QuarterlyReportService;
import com.seu.scrm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaosuo on 2019/3/5.
 */
@Service(value = "ReportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    PersonReportService personReportService;
    @Autowired
    HotReportService hotReportService;
    @Autowired
    QuarterlyReportService quarterlyReportService;

    @Override
    public String queryPersonReport(PersonRequest request) {
        // Todo
        // 校验参数逻辑合理性


        //创建返回的消息体中的data部分
        PersonalStat stat = new PersonalStat(request.getUserId());
        String type = request.getStatisDimens();
        stat.setReportType("person");
        stat.setStatisDimens(type);
        ReportResult result = new ReportResult<PersonalStat>();

        //根据不同的获取的统计信息的类型，调用不同的服务
        switch(type){
            case "brand":
                List<List<BrandSales>> brandSalesList =
                        personReportService.queryBrandSales(request.getUserId(),
                        request.getSubNum());
                stat.setBrandSalesList(brandSalesList);
                break;

            case "category":
                List<List<CategorySales>> categorySalesList =
                        personReportService.queryCategorySales(request.getUserId(),
                        request.getSubNum());
                stat.setCategorySalesList(categorySalesList);
                break;

            case "product":
                List<List<ProductSales>> productSalesList =
                        personReportService.queryProductSales(request.getUserId(),
                                request.getSubNum());
                stat.setProductSalesList(productSalesList);
                break;
            case "time":
                List<List<Sales>> timeSalesList =
                        personReportService.queryTimeSales(request.getUserId(),
                                request.getSubNum());
                stat.setTimeSalesList(timeSalesList);
                break;
            case "price":
                List<List<PriceSales>> priceSalesList =
                        personReportService.queryPriceSales(request.getUserId(),
                                request.getSubNum());
                stat.setPriceSalesList(priceSalesList);
                break;

            default:
                //Todo
                break;

        }

        //封装消息体返回
        result.setMsgCode(0);
        result.setMsgDesc("Success");
        result.setData(stat);
        String resultJson = JSON.toJSONString(result);
        return resultJson;
    }

    @Override
    public String queryHotReport(HotRequest request) {
        // Todo
        // 校验参数逻辑合理性


        //创建返回的消息体中的data部分
        HotStat stat = new HotStat();
        String type = request.getStatisDimens();
        stat.setReportType("hot");
        stat.setStatisDimens(type);
        ReportResult result = new ReportResult<HotStat>();

        //根据不同的获取的统计信息的类型，调用不同的服务
        switch(type){
            case "brand":
                List<List<BrandSales>> brandSalesList =
                        hotReportService.queryBrandSales(request.getPeriod(),
                                request.getSubNum());
                stat.setBrandSalesList(brandSalesList);
                break;

            case "category":
                List<List<CategorySales>> categorySalesList =
                        hotReportService.queryCategorySales(request.getPeriod(),
                                request.getSubNum());
                stat.setCategorySalesList(categorySalesList);
                break;

            case "product":
                List<List<ProductSales>> productSalesList =
                        hotReportService.queryProductSales(request.getPeriod(),
                                request.getSubNum());
                stat.setProductSalesList(productSalesList);
                break;

            default:
                //Todo
                break;

        }

        //封装消息体返回
        result.setMsgCode(0);
        result.setMsgDesc("Success");
        result.setData(stat);
        String resultJson = JSON.toJSONString(result);


        return resultJson;
    }

    @Override
    public String queryQuarterlyReport(QuarterlyRequest request) {
        // Todo
        // 校验参数逻辑合理性


        //创建返回的消息体中的data部分
        QuarterlyStat stat = new QuarterlyStat();
        String type = request.getStatisDimens();
        String subType = request.getSubType();
        stat.setReportType("quarterly");
        stat.setStatisDimens(type);
        ReportResult result = new ReportResult<HotStat>();

        //根据不同的获取的统计信息的类型，调用不同的服务
        switch(type){
            case "total":
                System.out.println("subType = " + subType);
                if(subType.toLowerCase().equals("category")){
                    List<List<CategorySales>> categorySalesList
                            = quarterlyReportService.queryAllCategorySales(
                                    request.getYear(), request.getSubNum());
                    stat.setCategorySalesList(categorySalesList);
                }
                else if(subType.toLowerCase().equals("product")){
                    List<List<ProductSales>> productSalesList
                            = quarterlyReportService.queryAllProductSales(
                            request.getYear(), request.getSubNum());
                    stat.setProductSalesList(productSalesList);
                }
                else
                {
                    List<List<Sales>> salesList =
                            quarterlyReportService.queryTotalSales(
                                    request.getYear(), request.getSubNum());
                    stat.setTotalSalesList(salesList);
                }

                break;

            case "category":
                if(subType.toLowerCase().equals("product")){
                    List<List<ProductSales>> productSalesList
                            = quarterlyReportService.queryCategoryProductSales(
                            request.getYear(), request.getDimensParam(),request.getSubNum());
                    stat.setProductSalesList(productSalesList);
                }
                else
                {
                    List<List<CategorySales>> categorySalesList =
                            quarterlyReportService.queryCategorySales(
                                    request.getYear(), request.getDimensParam(),request.getSubNum());
                    stat.setCategorySalesList(categorySalesList);
                }
                break;

            case "product":
                List<List<ProductSales>> productSalesList =
                        quarterlyReportService.queryProductSales(request.getYear(),
                                request.getDimensParam(), request.getSubNum());
                stat.setProductSalesList(productSalesList);
                break;

            default:
                //Todo
                break;

        }

        //封装消息体返回
        result.setMsgCode(0);
        result.setMsgDesc("Success");
        result.setData(stat);
        String resultJson = JSON.toJSONString(result);


        return resultJson;
    }
}
