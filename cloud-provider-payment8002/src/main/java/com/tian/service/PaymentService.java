package com.tian.service;

import com.tian.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentService
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/7/8 21:29
 */
public interface PaymentService {
    /**
     *
     * @param payment 接收
     * @return 返回数据
     */
    public int createPayment(Payment payment);

    /**
     *
     * @param id 接收一个id
     * @return  返回数据
     */
    public Payment getPaymentById(@Param("id") Long id);

}
