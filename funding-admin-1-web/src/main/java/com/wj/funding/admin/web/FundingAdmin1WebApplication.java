package com.wj.funding.admin.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wj.funding.admin.mapper")
public class FundingAdmin1WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundingAdmin1WebApplication.class, args);
    }

}
