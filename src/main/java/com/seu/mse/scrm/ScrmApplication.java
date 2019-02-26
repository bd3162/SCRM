package com.seu.mse.scrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Controller
public class ScrmApplication {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "This is SCRM project.";
    }


    public static void main(String[] args) {

        SpringApplication.run(ScrmApplication.class, args);
    }

}
