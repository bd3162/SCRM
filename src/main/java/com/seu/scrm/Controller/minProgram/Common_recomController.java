package com.seu.scrm.Controller.minProgram;

import com.seu.scrm.Entity.Common_recom;
import com.seu.scrm.Entity.Personal_recom;
import com.seu.scrm.Service.Common_recomService;
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
@RestController
@RequestMapping("/common_recom")
public class Common_recomController {
    @Autowired
    private Common_recomService common_recomService;
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Map<String,Object>selectById(String prod_asin){
        Map<String,Object> map=new HashMap<>();
        if(prod_asin!=null){
            Common_recom common_recom=common_recomService.selectById(prod_asin);
            map.put("common_recom",common_recom);
            map.put("prod_asin",common_recom.getProd_asin());
            map.put("update_time",common_recom.getUpdate_time());
        }else{
            map.put("common_recom",false);
        }
        return map;
    }
    //查找所有
    @RequestMapping(value="/selectList" ,method = RequestMethod.GET)
    public  Map<String,Object> selectList() {
        List<Common_recom> list= new ArrayList<>();
        list =common_recomService.select();
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return  map ;
    }
    //按id查找

    //添加
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    public Map<String,Object> add(Common_recom common_recom) {
        Map<String,Object> map=new HashMap<>();
        if(common_recom.getProd_asin()!=null){
            common_recomService.insert(common_recom);
            map.put("success",true);
        }else{
            map.put("success",false);
        }

        return map;
    }
    //去修改信息
    @RequestMapping(value="/toModify" ,method = RequestMethod.GET)
    public Map<String,Object> tomodify(String prod_asin) {
        Common_recom common_recomTemp=common_recomService.selectById(prod_asin);
        Map<String,Object> map=new HashMap<>();
        map.put("common_recomTemp",common_recomTemp);
        return map;
    }
    @RequestMapping(value="/Modify" ,method = RequestMethod.POST)
    public Map<String,Object>modify(Common_recom common_recom){
        common_recomService.update(common_recom);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }
    //删除信息
    @RequestMapping(value="/delete" ,method = RequestMethod.GET)
    public  Map<String,Object> delete(String prod_asin) {
        Map<String,Object> map=new HashMap<>();
        Common_recom common_recomTemp=common_recomService.selectById(prod_asin);
        if(common_recomTemp!=null){
            common_recomService.delete(prod_asin);
            map.put("success",true);
        }else {
            map.put("success",false);
        }
        return map;
    }


}
