package com.seu.scrm.Controller.Cashier;
        /*
         * @description: 收银员端的controller，实现在用户结账时，对于商品数据查询以及会员用户的积分存储
         * @author: karin
         * */

import com.seu.scrm.Entity.customer;
import com.seu.scrm.Entity.product;
import com.seu.scrm.Mapper.CashMapper;
import com.seu.scrm.Service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cashier")
public class CashierController {

    @Autowired
    private CashierService cashierService;

    @PostMapping("/findProd")
    @ResponseBody//响应体自动改json格式
    public List<product> findProdByID(@RequestParam("asin") String asin){
        return  cashierService.findProdByID(asin);
    }

    @RequestMapping("/addOrder")
    @ResponseBody
    public Map<String, Object> addOrder(@RequestParam("user_id") String user_id, @RequestParam("prod_asin") String prod_asin){
        //利用hashMap存储插入成功的返回值，告诉客户端插入数据成功
        Map<String, Object> map = new HashMap<String, Object>();
        int value = cashierService.addOrder(user_id,prod_asin);
        map.put("value", value);
        return map;
    }

    @RequestMapping("/updatePoints")
    @ResponseBody
    public Map<String, Object> updatePoints(@RequestParam ("user_id") String user_id,@RequestParam("memb_points") int memb_points){

        customer _customer=cashierService.findCustomerByID(user_id);
        int old_points=_customer.getMemb_points();//会员原来的积分
        memb_points+=old_points;

        //更新会员积分
        Map<String, Object> map = new HashMap<String, Object>();
        int value=cashierService.updatePoints(user_id,memb_points);

        map.put("value",value);
        return map;
    }

}
