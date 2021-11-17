package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author y
 * @create 2021/11/15 18:50
 */

@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentFeignService {

    @RequestMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Integer id);


    @RequestMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Integer id);

}
