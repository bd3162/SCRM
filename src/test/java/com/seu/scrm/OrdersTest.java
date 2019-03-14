package com.seu.scrm;

import com.seu.scrm.Controller.minProgram.PhxOrdersController;
import com.seu.scrm.Entity.OrderGroupWare;
import com.seu.scrm.Entity.Orders;
import com.seu.scrm.Entity.Product;
import com.seu.scrm.Service.OrdersService;
import com.seu.scrm.Service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrdersTest extends ScrmApplicationTests {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private PhxOrdersController ordersController;
    //@Test
    public  void testgetOrders(){
        System.out.println(ordersController.selectCustomerByOpenId("oyPj64t9XG6uf6-vnTvZoIydy2Ys"));

    }
    //@Test
    public void testselectOrdersByUserOpenId(){
       System.out.println(ordersController.selectOrdersByUserOpenId("oyPj64t9XG6uf6-vnTvZoIydy2Ys"));
    }
    //@Test
    public void testselectByUserId(){

        //根据user_id查询orders
        List<Orders> listOrders=new ArrayList<>();
        listOrders=ordersService.selectByUserId("1");
        System.out.println(listOrders.toString());

    }
   // @Test
    public void testselectProductById(){
            Product productTemp=productService.selectProductById("1");
            String title=productTemp.getTitle();
           System.out.println(title);

    }
    @Test
    public void testListOrderGroupWare(){
        List<OrderGroupWare> listOrderGroupWare=new ArrayList<>();
        OrderGroupWare orderGroupWare=new OrderGroupWare();
        List<Orders> listOrders=new ArrayList<>();
        listOrders=ordersService.selectByUserId("1");
        for(int i=0;i<listOrders.size();i++){
            String prod_asinTemp=listOrders.get(i).getProd_asin();
            int num=listOrders.get(i).getNum();
            int unix_time=listOrders.get(i).getUnix_time();
            System.out.println(prod_asinTemp);
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
        for(int i=0;i<listOrderGroupWare.size();i++){
            String title=listOrderGroupWare.get(i).getTitle();
            System.out.println(title);
        }
    }
    @Test
    public void testListOrderGroupWareTwo(){
        List<OrderGroupWare> listOrderGroupWare=new ArrayList<>();

        List<Orders> listOrders=new ArrayList<>();
        listOrders=ordersService.selectByUserId("1");
        for(int i=0;i<listOrders.size();i++){

            OrderGroupWare orderGroupWare=new OrderGroupWare();
            String prod_asinTemp=listOrders.get(i).getProd_asin();
            int num=listOrders.get(i).getNum();
            int unix_time=listOrders.get(i).getUnix_time();
            System.out.println(prod_asinTemp);
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
        for(int i=0;i<listOrderGroupWare.size();i++){
            String title=listOrderGroupWare.get(i).getTitle();
            System.out.println(title);
        }
    }

}
