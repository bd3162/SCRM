package com.seu.scrm.Service;

import com.seu.scrm.Entity.Common_recom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Common_recomService {

    void delete(String prod_asin);

    void insert( Common_recom common_recom);

    void update( Common_recom common_recom);

    Common_recom selectById(  String prod_asin);

    List<Common_recom> select();
    //大众推荐用到了
    List<Common_recom> selectByUpdateTime();
}
