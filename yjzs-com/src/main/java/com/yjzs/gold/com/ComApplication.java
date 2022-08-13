package com.yjzs.gold.com;


import com.yjzs.gold.feign.clients.TUserClient;
import com.yjzs.gold.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Tght
 * @EnableFeignClients(clients = TUserClient.class)
 * @EnableFeignClients(clients = TUserClient.class, defaultConfiguration = DefaultFeignConfiguration.class) 要指明,不然都跑不起来
 */
@EnableFeignClients(clients = TUserClient.class, defaultConfiguration = DefaultFeignConfiguration.class)
@MapperScan(value = {"com.yjzs.gold.com.mapper"})
@SpringBootApplication
public class ComApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComApplication.class, args);
    }
}
