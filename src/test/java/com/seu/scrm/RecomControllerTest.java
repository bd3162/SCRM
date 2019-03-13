package com.seu.scrm;

import com.seu.scrm.Controller.minProgram.RecomController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecomControllerTest extends ScrmApplicationTests{
    @Autowired
    private RecomController recomController;
    private String openId="oyPj64t9XG6uf6-vnTvZoIydy2Ys";
    @Test
    public  void testacceptOpenId(){
        Map<String,Object> map =new HashMap<>();
        map=recomController.acceptOpenId(openId);
        System.out.println(map.toString());
    }
    @Test
    public void testpersonalSelectList(){
        Map<String,Object> map=new HashMap<>();
        map=recomController.personalSelectList();
        System.out.println(map.toString());
    }
    @Test
    public void testselectCustomerByOpenId(){
        Map<String,Object> map=new HashMap<>();
        map=recomController.acceptOpenId(openId);
        System.out.println(map.toString());
    }
    @Test
    public void testSaveProductAsin(){
        List<String> listProd_asin= new ArrayList<>();
        listProd_asin=recomController.saveProductAsin("1");
        System.out.println(listProd_asin.toString());
    }
    @Test
    public void testSelectByUpdateTime(){
        List<String> list= new ArrayList<>();
        list=recomController.selectByUpdateTime();
        System.out.println(list.toString());
    }
}
