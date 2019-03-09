package com.seu.scrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.seu.scrm.Mapper")
@SpringBootApplication
public class ScrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrmApplication.class, args);
    }

}
