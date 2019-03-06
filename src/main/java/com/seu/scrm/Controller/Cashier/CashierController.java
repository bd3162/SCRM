package com.seu.scrm.Controller.Cashier;
        /*
         * @description: 收银员端的controller，实现在用户结账时，对于商品数据查询以及会员用户的积分存储
         * @author: karin
         * */

import com.seu.scrm.Entity.customer;
import com.seu.scrm.Entity.product;

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


    /**
     * @Description: 产生4位验证码，转发创建会话
     * @Param: 
     * @Return: 
     * @Author: karin
     */
/*
    @RequestMapping("/code")
    public ModelAndView getCode(@RequestParam("face_id") String face_id, HttpSession sessionn){

        //产生4位验证码
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=4;i++){
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }

        String code=sb.toString();

        //封装成map集合,存入session
        Map<String, Object> message = new HashMap<String, Object>();
        message.put("code",code);
        message.put("face_id",face_id);
        sessionn.setAttribute("message",message);

        ModelAndView mav = new ModelAndView("session");
        mav.addObject("message", message);
        return mav;

    }

   */

   /* @RequestMapping("/addOpenId")
    @ResponseBody
    public String addOpenId(@RequestParam("open_id") String open_id, @RequestParam("code") String code){

    }*/
}
