package com.wj.funding.admin.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.wj.funding.admin")
@MapperScan(basePackages = "com.wj.funding.admin.mapper")
public class FundingAdmin1WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundingAdmin1WebApplication.class, args);
    }

}
