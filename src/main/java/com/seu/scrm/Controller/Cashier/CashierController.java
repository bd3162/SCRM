package com.seu.scrm.Controller.Cashier;
        /*
         * @description: 收银员端的controller，实现在用户结账时，对于商品数据查询以及会员用户的积分存储
         * @author: karin
         * */


import com.seu.scrm.Service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@CrossOrigin//准许跨域访问
@RequestMapping("/cashier")
public class CashierController {

    @Autowired
    private CashierService cashierService;

    //用于存储验证码，用于验证码比对
    private String theLatestCode = null;

    @PostMapping("/findProd")
    @ResponseBody//响应体自动改json格式
    public Map<String, Object> findProdByID(@RequestParam("asin") String asin){
        Map<String, Object> map = new HashMap<String, Object>();
        map=cashierService.findProdByID(asin);
        return map;
    }

    @RequestMapping("/addOrder")
    @ResponseBody
    public Map<String, Object> addOrder(@RequestParam("user_id") String user_id, @RequestParam("prod_asin") String prod_asin,@RequestParam("num") int num){
        Map<String, Object> map = new HashMap<String, Object>();
        map=cashierService.addOrder(user_id,prod_asin,num);
        return map;
    }

    @RequestMapping("/updatePoints")
    @ResponseBody
    public Map<String, Object> updatePoints(@RequestParam ("user_id") String user_id,@RequestParam("total") int total){
        Map<String, Object> map = new HashMap<String, Object>();

        Map<String, Object> _customer=cashierService.findCustomerByID(user_id);
        int memb_points=(int)_customer.get("memb_points");//会员原来的积分
        memb_points += total ;

        //更新会员积分
        map=cashierService.updatePoints(user_id,memb_points);
        return map;
    }

    @RequestMapping("/getVerif")
    @ResponseBody
    public  Map<String, Object> getVerif(@RequestParam("user_id") String user_id){

        Map<String, Object> map = new HashMap<String, Object>();

        //查询用户信息
        Map<String,Object> customerMap =cashierService.findCustomerByID(user_id);
        //用户存在，未绑定open_id，产生验证码用户绑定open_id
        if(customerMap!=null && customerMap.get("open_id")==null) {

            //产生4位验证码
            String base = "0123456789";
            int size = base.length();
            Random r = new Random();
            StringBuffer code = new StringBuffer();
            for (int i = 1; i <= 4; i++) {
                int index = r.nextInt(size);
                char c = base.charAt(index);
                code.append(c);
            }

            String verif = code.toString();
            theLatestCode=verif;
            map=cashierService.updateVerif(user_id,verif);

            map.put("member",false);

        }else if(customerMap!=null) {
            //用户存在，已经绑定open_id
            map.put("open_id",customerMap.get("open_id"));
            map.put("member", true);
        }else {
            //用户不存在
            map.put("message",false);
        }
        return map;
    }

    /**
     * @Description: 微信端输入验证码，修改用户的open_id
     * @Param: 
     * @Return: 
     * @Author: karin
     */
    @RequestMapping(value="/updateOpenId")
    @ResponseBody
    public Map<String, Object> updateOpenId(@RequestParam("open_id") String open_id, @RequestParam("verif") String verif){
        System.out.println("open_id"+open_id+"=====verif:"+verif);
        Map<String,Object> map =new HashMap<>();

        if(verif.equals(theLatestCode)) {
            //字符串比值用equals函数
            map=cashierService.updateOpen_id(open_id,verif);
        }else {
            map.put("message",false);
        }
        return map;
    }
}
