package com.seu.scrm.Service;

import com.seu.scrm.Entity.Common_recom;
import com.seu.scrm.Mapper.Common_recomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Common_recomServiceImpl implements Common_recomService {
    @Autowired
    private Common_recomMapper common_recomMapper;
    @Override
    public void delete(String prod_asin) {
        if(prod_asin!=null){
           common_recomMapper.delete(prod_asin);
        }else{

        }
    }

    @Override
    public void insert(Common_recom common_recom) {
        common_recomMapper.insert(common_recom);
    }

    @Override
    public void update(Common_recom common_recom) {
         common_recomMapper.update(common_recom);
    }

    @Override
    public Common_recom selectById(String prod_asin) {
        return common_recomMapper.selectById(prod_asin);
    }

    @Override
    public List<Common_recom> select() {
        return common_recomMapper.select();
    }
    //大众推荐
    @Override
    public List<Common_recom> selectByUpdateTime() {
        return common_recomMapper.selectByUpdateTime();
    }
}
