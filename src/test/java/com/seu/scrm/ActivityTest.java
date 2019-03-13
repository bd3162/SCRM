package com.seu.scrm;

import com.seu.scrm.Controller.minProgram.ActivityController;
import com.seu.scrm.Entity.Activity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class ActivityTest extends ScrmApplicationTests {
    @Autowired
    private ActivityController activityController;
    @Test
    public void testSelectListActivity(){
        Map<String,Object> map=new HashMap<>();
        map=activityController.selectListActivity();
        System.out.println(map.toString());
    }
    @Test
    public void testSelectActivityById(){
        Map<String,Object> map=new HashMap<>();
        map=activityController.selectActivityById(1);
        System.out.println(map.toString());
    }
    @Test
    public void tesTomodifyActivity(){
        Map<String,Object> map=new HashMap<>();
        map=activityController.tomodifyActivity(1) ;
        System.out.println(map.toString());
    }
    @Test
    public void testAddActivity(){
        Activity activity=new Activity();
       // activity.setId(6);
        activity.setActiv_title("phx");
        activity.setActiv_img("htpp:baidu.com");
        activity.setActiv_desc("双十一哈哈哈哈");
        activity.setStart_date(1);
        activity.setEnd_date(3);
        Map<String,Object> map=new HashMap<>();
        map=activityController.addActivity(activity);
        System.out.println(map.toString());

    }

}
