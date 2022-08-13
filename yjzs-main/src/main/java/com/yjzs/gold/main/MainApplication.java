package com.yjzs.gold.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author Tght
 * @EnableFeignClients Feign自动装配开关
 * @EnableFeignClients(clients = {UserClient.class},defaultConfiguration = DefaultFeignConfiguration.class)
 * @EnableFeignClients(basePackages = {"com.yjzs.gold.feign.clients"},defaultConfiguration = DefaultFeignConfiguration.class)
 * @EnableScheduling 开启定时功能的注解
 * @EnableAsync 开启异步注解功能
 */
@EnableAsync
@EnableScheduling
@MapperScan(value = {"com.yjzs.gold.main.mapper"})
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
