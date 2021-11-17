package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author y
 * @create 2021/11/15 18:48
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix

public class OrderHystrixFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixFeignMain80.class,args);
    }
}
