package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author y
 * @create 2021/11/15 18:54
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_paymentInfo_fallback")
public class OrderFeignController {

    @Autowired
    PaymentFeignService paymentFeignService;


    @RequestMapping("/payment/hystrix/ok/{id}")
    @HystrixCommand
    String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_ok(id);
    }


    @RequestMapping("/payment/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentInfo_fallback",commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    // })
    @HystrixCommand
    String paymentInfo_timeout(@PathVariable("id") Integer id){

        return paymentFeignService.paymentInfo_timeout(id);
    }



    public String paymentInfo_fallback(@PathVariable("id") Integer id){

        return paymentFeignService.paymentInfo_ok(id) + "fallback （づ￣3￣）づ╭❤～";
    }

    public String global_paymentInfo_fallback(){

        return "global_paymentInfo_fallback （づ￣dededed￣）づ╭❤～";
    }





}
