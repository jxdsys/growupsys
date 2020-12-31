package com.jxd.growup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.jxd.growup.dao")
public class GrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrowApplication.class);
    }
}
