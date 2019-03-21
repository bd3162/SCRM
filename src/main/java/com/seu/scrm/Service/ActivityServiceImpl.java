package com.seu.scrm.Service;

import com.seu.scrm.Entity.Activity;
import com.seu.scrm.Mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl  implements  ActivityService{
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    public RedisTemplate<Object, Object> redisTemplate1;
    @Override
    public List<Activity> selectActivity()  {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();
        redisTemplate1.setKeySerializer(stringSerializer);
        redisTemplate1.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate1.setHashKeySerializer(stringSerializer);
        redisTemplate1.setHashValueSerializer(genericJackson2JsonRedisSerializer);

        List<Activity> activityList=(List<Activity>)redisTemplate1.opsForValue().get("allActivity");
        if(null==activityList){
            activityList=activityMapper.select();
            redisTemplate1.opsForValue().set("allActivity",activityList);
        }
        return activityList;
        //  return activityMapper.select();
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
