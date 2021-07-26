package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author y
 * @create 2021/7/27 0:47
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);


    Payment getPaymentById(@Param("id") Long id);
}
