package com.atguigu.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author y
 * @create 2021/7/28 0:00
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced 手写轮训算法就不用他自己的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
