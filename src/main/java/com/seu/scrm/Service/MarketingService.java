package com.seu.scrm.Service;

import com.alibaba.fastjson.JSON;
import com.seu.scrm.Entity.Customer;
import com.seu.scrm.Entity.EntranceEvents;
import com.seu.scrm.Mapper.CustomerMapper;
import com.seu.scrm.Mapper.EntranceEventsMapper;
import com.seu.scrm.Mapper.Personal_recomMapper;
import com.seu.scrm.Mapper.SalesRecommendMapper;
import com.seu.scrm.Utils.MsgCode;
import com.seu.scrm.dto.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.logging.Logger;


/**
 * Created by chenxiaosuo on 2019/3/19.
 */
@Service(value = "MarketingService")
public class MarketingService {
    @Autowired
    private EntranceEventsMapper entranceEventsMapper;
    @Autowired
    private SalesRecommendMapper salesRecommendMapper;
    @Autowired
    private CustomerMapper customerMapper;

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MarketingService.class);


    /*时间*/
    private static final int ENTRANCE_DELAY = 5;

    /*发送状态*/
    private static final int RECOMMEND_SENT = 1;
    private static final int RECOMMEND_NOT_SENT = 0;



    /**
     * 处理人脸通知信息
     * @param captureNotify
     * @return
     */
    public String handleCaptureNotify(CaptureNotify captureNotify){
        ReportResult<Object> result = new ReportResult<Object>();
        //Todo 插入数据库待推送的推荐信息
        EntranceEvents record = new EntranceEvents();
        record.setIsSent(0);
        record.setIsOld(captureNotify.getIsOld());
        record.setUserId(captureNotify.getUserId());
        logger.debug("CaptureNotify: " + captureNotify.toString());
        int res = entranceEventsMapper.insertSelective(record);

        //返回响应
        result.setData(null);
        if(res > 0){
            result.setMsgCode(MsgCode.SERVICE_OK.getCode());
            result.setMsgDesc(MsgCode.SERVICE_OK.getMsg());
        }else{
            result.setMsgCode(MsgCode.DB_UPDATE_FAILURE.getCode());
            result.setMsgDesc(MsgCode.DB_UPDATE_FAILURE.getMsg());
        }

        return JSON.toJSONString(result);
    }


    /**
     * 获取推荐信息
     * @param salesManId
     * @return
     */
    public String queryRecommendation(String salesManId){
        ReportResult<Object> result = new ReportResult<Object>();
        //Todo 根据销售员的信息获取关注的类别


        //获取推荐信息
        //step1: 首先尝试获取 5min以内，没有发送过得用户
        EntranceEvents entranceEvents = null;
        entranceEvents = entranceEventsMapper.queryEntranceEvent(ENTRANCE_DELAY * 60, RECOMMEND_NOT_SENT);
        //step2: 若获取不到，则尝试获取 5min以内，已经发送过得用户
        if(entranceEvents == null){
            entranceEvents = entranceEventsMapper.queryEntranceEvent(ENTRANCE_DELAY * 60, RECOMMEND_SENT);
        }
        //step3.1: 若仍然获取不到，则返回空
        if(entranceEvents == null){
            result.setData(null);
            result.setMsgCode(MsgCode.SERVICE_OK.getCode());
            result.setMsgDesc(MsgCode.SERVICE_OK.getMsg());
            return JSON.toJSONString(result);
        }

        //step3.2: 若获取到数据，则获取用户的推荐信息
        logger.info("entranceEvents: "+ entranceEvents.toString());
        String userId = entranceEvents.getUserId();
        if(entranceEvents.getIsOld() == 1){

            List<ProductInfo> productInfoList
                    =  salesRecommendMapper.queryPersonalProductList(userId);
            Customer customer = customerMapper.selectById(userId);
            UserInfo userInfo = new UserInfo(userId, customer.getAvatarUrl(), 1);
            SalesRecommendation salesRecommendation = new SalesRecommendation(userInfo, productInfoList);
            //设置已经发送过
            entranceEvents.setIsSent(1);
            entranceEventsMapper.updateEntranceEvent(entranceEvents);

            result.setData(salesRecommendation);
            result.setMsgCode(MsgCode.SERVICE_OK.getCode());
            result.setMsgDesc(MsgCode.SERVICE_OK.getMsg());
            return JSON.toJSONString(result);
        }
        //普通用户不给推荐
        else{
            //设置已经发送过
            entranceEvents.setIsSent(1);
            entranceEventsMapper.updateEntranceEvent(entranceEvents);

            result.setData(null);
            result.setMsgCode(MsgCode.SERVICE_OK.getCode());
            result.setMsgDesc(MsgCode.SERVICE_OK.getMsg());
            return JSON.toJSONString(result);
        }
    }
}
