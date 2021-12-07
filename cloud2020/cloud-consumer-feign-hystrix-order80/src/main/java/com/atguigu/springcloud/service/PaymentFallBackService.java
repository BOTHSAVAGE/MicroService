package com.atguigu.springcloud.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author y
 * @create 2021/11/17 11:49
 */
@Component
public class PaymentFallBackService implements PaymentFeignService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "paymentInfo_ok fallback";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "paymentInfo_timeout fallback";
    }
}
