package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.example.springboot.mapper")
public class SpringbootApplication {
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    public static void main(String[] args) {
//        System.out.println("hello word");
        SpringApplication.run(SpringbootApplication.class, args);
        logger.info("程序已启动");
    }
}
