package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author y
 * @create 2021/11/19 15:50
 */
@RestController
@RefreshScope
public class ConfigClientController {



    @Value("${config.info}")
    String info;


    @RequestMapping("/test")
    public String test(){
        return info;

    }

}
