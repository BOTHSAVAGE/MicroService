package com.atgugu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author y
 * @create 2021/8/10 23:27
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("/payment/consule")
    public String test(){
        return "springcloud with consul\t"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
