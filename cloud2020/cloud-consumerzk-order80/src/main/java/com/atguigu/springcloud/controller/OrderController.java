package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.atguigu.springcloud.entities.CommonResult;

import javax.annotation.Resource;

/**
 * @author y
 * @create 2021/7/28 17:21
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://CLOUD-PAYMENT-SERVICE";


    @GetMapping(value = "/consume/payment/zk")
    public String paymentInfo(){

        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
