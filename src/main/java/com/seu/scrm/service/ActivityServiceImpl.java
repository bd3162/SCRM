package com.seu.scrm.Service;

import com.seu.scrm.Entity.Activity;
import com.seu.scrm.Mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl  implements  ActivityService{
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> selectActivity()  {

        return activityMapper.select();
    }

    @Override
    public Activity selectActivityById(int activity_id) {
        return  activityMapper.selectById(activity_id);
    }

    @Override
    public void addActivity(Activity activity)  {

        activityMapper.insert(activity);
    }

    @Override
    public void modifyActivity(Activity activity)  {

        activityMapper.update(activity);
    }

    @Override
    public void deleteActivity(int activity_id)  {
         activityMapper.delete(activity_id);
    }
}
