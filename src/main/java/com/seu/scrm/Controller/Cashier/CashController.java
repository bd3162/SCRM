package com.seu.scrm.Controller.Cashier;

import com.seu.scrm.Entity.product;
import com.seu.scrm.Mapper.CashMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CashController {

    @Autowired
    private CashMapper cashMapper;

    @RequestMapping(value = "/findProd")
    public List<product> findProdByID(@RequestParam("asin") String asin){
        return cashMapper.findProdByID(asin);
    }

}
