package com.seu.scrm.Service;

import com.seu.scrm.Entity.Personal_recom;

import java.util.List;

public interface Personal_recomService {
    Personal_recom selectById(String user_id);
    void insert(Personal_recom personal_recom);
    void delete(String user_id);
    void update(Personal_recom personal_recom);
    List<Personal_recom> select();
    List<Personal_recom> selectByUserIdAndUpdateTime(String user_id);
}
