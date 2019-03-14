package com.seu.scrm.Controller.minProgram;

import com.seu.scrm.Entity.Customer;
import com.seu.scrm.Entity.OrderGroupWare;
import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Mapper.OrdersMapper;
import com.seu.scrm.Service.CustomerService;
import com.seu.scrm.Service.OrdersService;
import com.seu.scrm.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/orders")
@RestController
public class PhxOrdersController {
    @Autowired
    private ProductService productService;
   @Autowired
   private OrdersService ordersService;
   @Autowired
   private CustomerService customerService;

   @RequestMapping(value="/getOrders" ,method = RequestMethod.GET)
   public Map<String ,Object> selectOrdersByUserOpenId(String openid){

       //根据用户openId，查询userId,
       List<OrderGroupWare> listOrderGroupWare=new ArrayList<>();
       Map<String,Object> customerMap=new HashMap<>();
       customerMap=selectCustomerByOpenId(openid);
       String user_id=null;
       List<Orders> listOrders=new ArrayList<>();

       if(customerMap.get("user_id")!=null){
          user_id=(String)customerMap.get("user_id");
          //根据用户userid查询订单列表
          listOrders=ordersService.selectByUserId(user_id);
          //把订单集合中的productId放到一个单独集合
           for(int i=0;i<listOrders.size();i++){
               OrderGroupWare orderGroupWare=new OrderGroupWare();
               String prod_asinTemp=listOrders.get(i).getProd_asin();
               int num=listOrders.get(i).getNum();
               int unix_time=listOrders.get(i).getUnix_time();
               //根据商品编号prod_asinTemp,查找商品价格，和名称
               Product productTemp=productService.selectProductById(prod_asinTemp);
               double price=productTemp.getPrice();
               double totalPrice=price*num;
               String title=productTemp.getTitle();
               String imUrl=productTemp.getImUrl();
               orderGroupWare.setImUrl(imUrl);
               orderGroupWare.setProd_asin(prod_asinTemp);
               orderGroupWare.setNum(num);
               orderGroupWare.setPrice(price);
               orderGroupWare.setTatolPrice(totalPrice);
               orderGroupWare.setTitle(title);
               orderGroupWare.setUnix_time(unix_time);
               listOrderGroupWare.add(orderGroupWare);
           }

       }
       //放在一个组合的类中
        Map<String,Object> map=new HashMap<>();
       map.put("listOrderGroupWare",listOrderGroupWare);
       return map;

   }
    //根据用户openId，查询userId,
    public Map<String,Object> selectCustomerByOpenId(String open_id){
        Map<String,Object>map =new HashMap<>();
        if(open_id!=""&&open_id!=null){
            Customer customer=customerService.selectByOpenId(open_id);

            if(customer!=null){
                map.put("user_id",customer.getUser_id());
                map.put("verif",customer.getVerif());
                map.put("open_id",customer.getOpen_id());
                map.put("memb_points",customer.getMemb_points());
            }else {
                map.put("user_id",null);
            }

        }else{
            map.put("user_id",null);
        }
        return map;
    }

}
