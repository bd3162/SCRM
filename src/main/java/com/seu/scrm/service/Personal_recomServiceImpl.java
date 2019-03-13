package com.seu.scrm.Service;

import com.seu.scrm.Entity.Personal_recom;
import com.seu.scrm.Mapper.Personal_recomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Personal_recomServiceImpl  implements  Personal_recomService{
    @Autowired
    private Personal_recomMapper personal_recomMapper;
    @Override
    public Personal_recom selectById(int user_id) {
        return personal_recomMapper.selectById(user_id);
    }

    @Override
    public void insert(Personal_recom personal_recom) {
        personal_recomMapper.insert(personal_recom);
    }

    @Override
    public void delete(int user_id) {
        personal_recomMapper.delete(user_id);
    }

    @Override
    public void update(Personal_recom personal_recom) {
          personal_recomMapper.update(personal_recom);
    }

    @Override
    public List<Personal_recom> select() {
        List<Personal_recom> list=new ArrayList<>();
        list=personal_recomMapper.select();
        return list;
    }

    @Override
    public List<Personal_recom> selectByUserIdAndUpdateTime(String user_id) {
        return personal_recomMapper.selectByUserIdAndUpdateTime(user_id);
    }
}
