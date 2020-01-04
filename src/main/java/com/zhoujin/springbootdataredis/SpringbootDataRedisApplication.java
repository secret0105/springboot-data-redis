package com.zhoujin.springbootdataredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zhoujin")
public class SpringbootDataRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataRedisApplication.class, args);
    }

}
