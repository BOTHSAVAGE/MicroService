package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entities.CommonResult;

/**
 * @author y
 * @create 2021/11/15 18:54
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    PaymentFeignService paymentFeignService;


    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }




}
