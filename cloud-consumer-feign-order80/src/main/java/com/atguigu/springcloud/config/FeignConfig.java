package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * @author y
 * @create 2021/11/15 20:20
 */

@Configuration
public class FeignConfig {

    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
