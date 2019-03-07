package com.seu.scrm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seu.scrm.dto.*;
import com.seu.scrm.service.PersonReportService;
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

    @Override
    public String queryReport(PersonRequest request) {
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
                List<BrandSales> salesList = personReportService.queryBrandSales(request.getUserId(),
                    request.getSubNum());
                List<List<BrandSales>> brandSalesList= new ArrayList<List<BrandSales>>();
                brandSalesList.add(salesList);
                stat.setBrandSalesList(brandSalesList);

                break;

            default:
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
