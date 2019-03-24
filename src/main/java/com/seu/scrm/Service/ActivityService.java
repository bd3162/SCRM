package com.seu.scrm.Service;

import com.seu.scrm.Entity.Activity;

import java.util.List;

public interface ActivityService {
    //查看商品优惠信息
    public List<Activity> selectActivity() ;
    public Activity selectActivityById(int id) ;
   //添加活动信息
    public boolean addActivity(Activity activity) ;
    //修改活动信息
    public boolean modifyActivity(Activity activity)  ;
    //删除活动信息
    public  void deleteActivity(int id) ;


}
