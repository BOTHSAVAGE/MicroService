package com.atguigu.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sun.plugin2.message.GetNameSpaceMessage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author y
 * @create 2021/11/17 10:15
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){

        return "(*^▽^*)+线程池: "+Thread.currentThread().getName() + "   paymentInfo_ok,id:"+id;

    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {

            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "(灬ꈍ ꈍ灬)+线程池: "+Thread.currentThread().getName() + "   paymentInfo_TimeOut,id:"+id+"   睡了"+timeout+"秒";
    }




    public String paymentInfo_TimeOutHandler(Integer id){
        return "o(╥﹏╥)o+线程池: "+Thread.currentThread().getName() + "   paymentInfo_TimeOutHandler,id:"+id;

    }


    //服务熔断


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少时候跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString().replace('-',' ').trim();
        return Thread.currentThread().getName()+"\t 调用成功，流水号： "+serialNumber;
    }

    public String paymentCircuitBreaker_fallBack(@PathVariable("id") Integer id){
        return "id不能为负数";
    }


}
