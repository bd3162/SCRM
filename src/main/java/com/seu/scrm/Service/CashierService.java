package com.seu.scrm.Service;/*
 * @description: 收银员业务层
 * @author: karin
 * */
import com.seu.scrm.Entity.Customer;
import com.seu.scrm.Entity.Product;

import com.seu.scrm.Mapper.CashMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class CashierService {

    @Autowired
    private CashMapper cashMapper;

    /**
     * @Description: 根据商品asin查找商品，逻辑判断
     * @Param:
     * @Return:
     * @Author: karin
     */
    public Map<String, Object> findProdByID(@RequestParam("asin") String asin){
        Map<String, Object> map = new HashMap<String, Object>();
        if(asin != null && asin != "") {
            Product _product = cashMapper.findProdByID(asin);
            if( _product != null) {
                map.put("message",true);
                map.put("asin", _product.getAsin());
                map.put("title", _product.getTitle());
                map.put("price", _product.getPrice());
                map.put("imUrl", _product.getImUrl());
                map.put("cate", _product.getCate());
                map.put("brand", _product.getBrand());
            }
            else {
                map.put("message",false);
            }
        }
        else{
            map.put("message",false);
        }
        return map;
    }

    /**
     * @Description: 添加订单
     * @Param:
     * @Return:
     * @Author: karin
     */
    public Map<String, Object> addOrder(@RequestParam("user_id") String user_id, @RequestParam("prod_asin") String prod_asin,@RequestParam("num") int num){

        Map<String, Object> map = new HashMap<String, Object>();

        if(user_id!=null && user_id!="" && prod_asin!=null && prod_asin!="" && num!=0){
            Product _product = cashMapper.findProdByID(prod_asin);
            //商品不存在
            if(_product == null){
                map.put("message",false);
            }
            else if(cashMapper.addOrder(user_id, prod_asin, num)){
                map.put("message",true);
            }else {
                map.put("message",false);
            }
        }else {
            map.put("message",false);
        }
        return map;
    }

    /**
     * @Description: 添加新用户
     * @Param:
     * @Return:
     * @Author: karin
     */
    public Map<String, Object> addUser(@RequestParam("user_id") String user_id ){

        Map<String, Object> map = new HashMap<String, Object>();

        if(user_id!=null && user_id!="" ){

            if(cashMapper.addUser(user_id)){
                map.put("message",true);
            }else {
                map.put("message",false);
            }
        }else {
            map.put("message",false);
        }
        return map;
    }

    /**
     * @Description: 根据id查找用户
     * @Param:
     * @Return:
     * @Author: karin
     */
    public Map<String, Object> findCustomerByID(@RequestParam("user_id") String user_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(user_id != null && user_id != "") {
            Customer _customer = cashMapper.findCustomerByID(user_id);
            if( _customer != null) {
                map.put("message",true);
                map.put("user_id",_customer.getUser_id());
                map.put("face_idverif",_customer.getVerif());
                map.put("open_id",_customer.getOpen_id());
                map.put("memb_points",_customer.getMemb_points());
            }else {
                map.put("message",false);
            }
        }
        else{
            map.put("success",false);
        }
        return map;
    }

    /**
     * @Description: 更新用户积分
     * @Param:
     * @Return:
     * @Author: karin
     */
    public  Map<String, Object>  updatePoints(@RequestParam("user_id") String user_id, @RequestParam("memb_points") int memb_points){
        Map<String, Object> map = new HashMap<String, Object>();

        if(user_id!=null && user_id!="" && memb_points!=0){
            Customer _customer = cashMapper.findCustomerByID(user_id);
            //用户不存在
            if(_customer ==null){
                map.put("message",false);
            }
            else if(cashMapper.updatePoints(user_id,memb_points)){
                map.put("message",true);
            }else {
                map.put("message",false);
            }
        }else {
            map.put("message",false);
        }
        return map;
    }


    /**
     * @Description: 更新用户验证码
     * @Param:
     * @Return:
     * @Author: karin
     */
    public Map<String,Object> updateVerif(@RequestParam("user_id") String user_id, String verif){
        Map<String, Object> map = new HashMap<String, Object>();
         System.out.println("Service verif:"+verif);

         //验证码生成成功
        if(verif!=null) {
             //更新成功
             if (cashMapper.updateVerif(user_id, verif)) {
                 map.put("verif",verif);
                 map.put("message", true);
             } else {
                 map.put("message", false);
             }
        }else {
            map.put("message",false);
        }
        return map;
    }


    /**
     * @Description: 更新用户open_id,etc
     * @Param:
     * @Return:
     * @Author: karin
     */
    public Map<String,Object> updateOpen_id(@RequestParam("open_id") String open_id,@RequestParam("city") String city,@RequestParam("gender") int gender,@RequestParam("avatarUrl") String avatarUrl, @RequestParam("verif") String verif){
       //  , @Param("verif") String verif)
        Map<String, Object> map = new HashMap<String, Object>();
        if(cashMapper.updateOpen_id(open_id,city,gender,avatarUrl,verif)) {
            map.put("open_id",open_id);
            map.put("city",city);
            map.put("gender",gender);
            map.put("avatarUrl",avatarUrl);
            map.put("verif",verif);
            map.put("message", true);
        } else {
            map.put("message",false);
        }
        return map;
    }

}
