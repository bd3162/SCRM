package com.seu.scrm.Controller.minProgram;

import com.seu.scrm.Entity.Common_recom;
import com.seu.scrm.Entity.Customer;
import com.seu.scrm.Entity.Personal_recom;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Service.Common_recomService;
import com.seu.scrm.Service.CustomerService;
import com.seu.scrm.Service.Personal_recomService;
import com.seu.scrm.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("recom")
public class RecomController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private Common_recomService common_recomService;
    @Autowired
    private Personal_recomService personal_recomService;
    //个性化查找所有
    @RequestMapping(value="acceptOpenId",method = RequestMethod.GET)
    public  Map<String,Object>acceptOpenId( @RequestParam("openid") String openid){
        //根据openID,先去查询该用户是否是会员,是否有verif,
        List<Product> listProduct=new ArrayList<>();
        List<String> listProductId=new ArrayList<>();
        Map<String,Object>mapCustomer=selectCustomerByOpenId(openid);
        if(mapCustomer!=null&&mapCustomer.get("verif")!=null){
            //说明是注册的会员
            String user_id=(String)mapCustomer.get("user_id");
            //根据user_id和最大update_time去personal_recom查询出personal_recom
            listProductId=saveProductAsin(user_id);
            /*for(int i=0;i<listProductId.size();i++){
                String asin=listProductId.get(i);
                //根据asin查询商品
                Product productTemp=productService.selectProductById(asin);
                listProduct.add(productTemp);
            }
            Map<String,Object> map=new HashMap<>();
            map.put("listProduct",listProduct);
            return  map ;*/

        }else{
            //不是会员,大众推荐,获取大众推荐商品的id集合,再去查找商品集合
            listProductId=selectByUpdateTime();
        }
        for(int i=0;i<listProductId.size();i++){
            String asin=listProductId.get(i);
            Product productTemp=productService.selectProductById(asin);
            listProduct.add(productTemp);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("listProduct",listProduct);
        System.out.println(map.toString());
        return  map ;
    }
    @RequestMapping(value="/selectList" ,method = RequestMethod.GET)
    public Map<String,Object> personalSelectList() {
        List<Personal_recom> list= new ArrayList<>();
        list =personal_recomService.select();
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return  map ;
    }

    public  Map<String,Object> selectCustomerByOpenId(String open_id){
        Map<String,Object>map =new HashMap<>();
        if(open_id!=""&&open_id!=null){
            Customer customer=customerService.selectByOpenId(open_id);

            if(customer!=null){
                map.put("user_id",customer.getUser_id());
                map.put("verif",customer.getVerif());
                map.put("open_id",customer.getOpen_id());
                map.put("memb_points",customer.getMemb_points());
            }else {
                map.put("verif",null);
            }

        }else{
            map.put("verif",null);
        }
        return map;
    }
    //实现把personal_recom 中的prod_asin存到列表里
     public List<String> saveProductAsin(String user_id){
         List<String> listProd_asin= new ArrayList<>();
         List<Personal_recom> listPersonal_recom= new ArrayList<>();
         listPersonal_recom=personal_recomService.selectByUserIdAndUpdateTime(user_id);
         for(int i=0;i<listPersonal_recom.size();i++){
             listProd_asin.add(listPersonal_recom.get(i).getProd_asin());
         }
         return listProd_asin;
     }
    //大众推荐把商品放在List<Common_recom>中,并把最后的商品id 放在listProductAsin中；
      public List<String> selectByUpdateTime(){
          List<Common_recom> listCommonRecom=new ArrayList<>();
          List<String> listProductAsin=new ArrayList<>();
          listCommonRecom=common_recomService.selectByUpdateTime();
          for(int i=0;i<listCommonRecom.size();i++){
              String productAsin=listCommonRecom.get(i).getProd_asin();
              listProductAsin.add(productAsin);
          }
          return listProductAsin;
      }
}
