package com.seu.scrm.Controller.minProgram;

import com.seu.scrm.Entity.Activity;
import com.seu.scrm.Entity.Personal_recom;
import com.seu.scrm.Service.Personal_recomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RequestMapping("/personal_recom")
@RestController
public class Personal_recomController {
    @Autowired
    private Personal_recomService personal_recomService;
    //查找所有
    @RequestMapping(value="/selectList" ,method = RequestMethod.GET)
    public  Map<String,Object> selectList() {
       List<Personal_recom> list= new ArrayList<>();
       list =personal_recomService.select();
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return  map ;
    }
    //按id查找
    @RequestMapping(value="/selectById" ,method = RequestMethod.GET)
    public  Map<String,Object> selectById(String user_id){
        Map<String,Object> map=new HashMap<>();
        Personal_recom personal_recom=personal_recomService.selectById(user_id);
        if(personal_recom!=null){
            map.put("personal_recom",personal_recom);
            map.put("user_id",personal_recom.getUser_id());
            map.put("prod_asin",personal_recom.getProd_asin());
            map.put("rank",personal_recom.getRank());
            map.put("update_time",personal_recom.getUpdate_time());
        }else{
            map.put("success",false);
        }
        return map;
    }
    //添加
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    public Map<String,Object> add(Personal_recom personal_recom) {
        Personal_recom personal_recomTemp=personal_recomService.selectById(personal_recom.getUser_id());
        Map<String,Object> map=new HashMap<>();
        if(personal_recomTemp==null){
            personal_recomService.insert(personal_recom);
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return map;
    }
    //去修改信息
    @RequestMapping(value="/toModify" ,method = RequestMethod.GET)
    public Map<String,Object> tomodify(String user_id) {
        Personal_recom personal_recomTemp=personal_recomService.selectById(user_id);
        Map<String,Object> map=new HashMap<>();
        map.put("personal_recomTemp",personal_recomTemp);
        return map;
    }
    @RequestMapping(value="/Modify" ,method = RequestMethod.POST)
    public Map<String,Object>modify(Personal_recom personal_recom){
        personal_recomService.update(personal_recom);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }
    //删除信息
    @RequestMapping(value="/delete" ,method = RequestMethod.GET)
    public  Map<String,Object> delete(String user_id) {
        Map<String,Object> map=new HashMap<>();
        Personal_recom personal_recom=personal_recomService.selectById(user_id);
        if(personal_recom!=null){
            personal_recomService.delete(user_id);
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return map;
    }


}
