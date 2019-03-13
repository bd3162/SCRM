package com.seu.scrm;

import com.seu.scrm.Controller.minProgram.OpenIdController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class OpenIdTest extends  ScrmApplicationTests{
    @Autowired
    private OpenIdController openIdController;
    @Autowired
    HttpServletRequest request;
    HttpServletResponse response;
    @Test
    public void testGetOpenId(){

         String code="033dw7jv0AJGHi13zBiv0Xlcjv0dw7jb";
        Map<String,Object> map=new HashMap<>();
    try{

       map= openIdController.doPost(code,request,response);
       System.out.println(map.toString());
    }
        catch (Exception e){
        e.printStackTrace();
        }
         System.out.println();
    }
}
