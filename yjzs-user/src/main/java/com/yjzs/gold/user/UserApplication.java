package com.yjzs.gold.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Tght
 * @EnableFeignClients Feign自动装配开关
 */
@MapperScan(value = {"com.yjzs.gold.user.mapper"})
//@EnableFeignClients
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
