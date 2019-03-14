package com.seu.scrm.Controller.minProgram;

import com.seu.scrm.Entity.Activity;
import com.seu.scrm.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    //用到了
    @RequestMapping(value="/selectList" ,method = RequestMethod.GET)
    public  Map<String,Object> selectListActivity() {
        List<Activity> list =activityService.selectActivity();
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return  map ;
    }
    @RequestMapping(value="/selectById" ,method = RequestMethod.GET)
    public  Map<String,Object> selectActivityById(int id){
        Map<String,Object> map=new HashMap<>();
        Activity activity=activityService.selectActivityById(id);
        if(activity!=null){
            map.put("activity",activity);
            map.put("id",activity.getId());
            map.put("activ_title",activity.getActiv_title());
            map.put("activ_img",activity.getActiv_img());
            map.put("activ_desc",activity.getActiv_desc());
            map.put("start_date",activity.getStart_date());
            map.put("end_date",activity.getEnd_date());
        }else{
            map.put("success",false);
        }
        return map;
    }
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    public Map<String,Object> addActivity(Activity activity) {
        activityService.addActivity(activity);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }
    //去修改活动信息
    @RequestMapping(value="/toModify" ,method = RequestMethod.GET)
    public Map<String,Object> tomodifyActivity(int id)  {
        Activity activity=activityService.selectActivityById(id);
        Map<String,Object> map=new HashMap<>();
        if(activity!=null){
            map.put("activity",activity);
            map.put("id",activity.getId());
            map.put("activ_title",activity.getActiv_title());
            map.put("activ_img",activity.getActiv_img());
            map.put("activ_desc",activity.getActiv_desc());
            map.put("start_date",activity.getStart_date());
            map.put("end_date",activity.getEnd_date());
        }else{
            map.put("success",true);
        }

        return map;
    }
    @RequestMapping(value="/Modify" ,method = RequestMethod.POST)
    public Map<String,Object>modifyActivity(Activity activity){
        activityService.modifyActivity(activity);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }
    //删除活动信息
    @RequestMapping(value="/delete" ,method = RequestMethod.GET)
    public  Map<String,Object> deleteActivity(int activity_id) {
        Activity activity=activityService.selectActivityById(activity_id);
        Map<String,Object> map=new HashMap<>();
        if(activity!=null){
            activityService.deleteActivity(activity_id);
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return map;
    }

}
