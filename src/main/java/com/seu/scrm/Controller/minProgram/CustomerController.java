package com.seu.scrm.Controller.minProgram;

import com.seu.scrm.Entity.Customer;
import com.seu.scrm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
   @Autowired
   private CustomerService customerService;
   @RequestMapping(value="/selectCustomerByOpenId",method = RequestMethod.GET)
   public  Map<String,Object> selectCustomerByOpenId(@RequestParam String open_id){
       Map<String,Object>map =new HashMap<>();
       Customer customer=customerService.selectByOpenId(open_id);
       if(customer!=null){
           String verif=customer.getVerif();
           if(verif!=null){
               map.put("customer",customer);
           }else{
               map.put("customer",null);
           }
       }else{
           map.put("customer",null);
       }
       return map;
   }
   @RequestMapping(value="/updateOpenId",method = RequestMethod.GET)
   public  Map<String,Object> updateOpenId(String open_id,String user_id){
       Map<String,Object>map =new HashMap<>();
       if(open_id!=null && user_id!=null){
           Customer customer=new Customer();
           customer.setOpen_id(open_id);
           customer.setUser_id(user_id);
           customerService.updateOpenId(customer);
           map.put("success",true);
       }else{
           map.put("success",false);
       }
       return map;
   }
   //添加open_id
   @RequestMapping(value="/toUpdate",method = RequestMethod.GET)
   public Map<String,Object> toupdate(String user_id){
       Map<String,Object>map =new HashMap<>();
       Customer customer=customerService.selectById(user_id);
       if(customer!=null){
           map.put("customer",customer);
           map.put("user_id",customer.getUser_id());
           map.put("verif",customer.getVerif());
           map.put("open_id",customer.getOpen_id());
           map.put("memb_points",customer.getMemb_points());
       }else{
          map.put("success",false) ;
       }
       return map;
   }
    @RequestMapping(value="/update",method = RequestMethod.POST)
   public Map<String,Object> update(Customer customer){
        Map<String,Object>map =new HashMap<>();
        if(customer.getUser_id()!=null && customer.getUser_id()!=""){
            customerService.update(customer);
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return map;
   }
   @RequestMapping(value="/delete",method = RequestMethod.GET)
   public  Map<String,Object> delete(String user_id){
       Map<String,Object>map =new HashMap<>();
       Customer customer=customerService.selectById(user_id);
       if(customer!=null){
           customerService.delete(user_id);
           map.put("success",true);
       }else{
           map.put("success",false);
       }
       return map;
   }
    @RequestMapping(value="/selectById",method = RequestMethod.GET)
   public  Map<String,Object> selectById(String user_id){
        Map<String,Object>map =new HashMap<>();
        if(user_id!=""&&user_id!=null){
            Customer customer=customerService.selectById(user_id);
            map.put("customer",customer);
            map.put("user_id",customer.getUser_id());
            map.put("verif",customer.getVerif());
            map.put("open_id",customer.getOpen_id());
            map.put("memb_points",customer.getMemb_points());
        }else{
            map.put("success",false);
        }
        return map;
    }
    @RequestMapping(value="/selectList",method = RequestMethod.GET)
    public  Map<String,Object> select(){
        Map<String,Object>map =new HashMap<>();
        List<Customer> list=customerService.select();
        map.put("list",list);
        return map;
    }

}
