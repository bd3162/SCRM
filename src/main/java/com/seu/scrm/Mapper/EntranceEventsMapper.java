package com.seu.scrm.Mapper;


import com.seu.scrm.Entity.EntranceEvents;
import org.apache.ibatis.annotations.Param;

/**
 * Created by chenxiaosuo on 2019/3/19.
 */
public interface EntranceEventsMapper {

    /**
     * 插入新事件
     * @param record
     * @return
     */
    int insertSelective(EntranceEvents record);


    /**
     * 获取用户入场事件
     * @param second
     * @param isSent
     * @return
     */
    EntranceEvents queryEntranceEvent(@Param("second") int second, @Param("isSent") int isSent);

    /**
     * 更新用户入场事件下发状态
     * @param record
     * @return
     */
    int updateEntranceEvent(EntranceEvents record);
}
