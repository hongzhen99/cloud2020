package com.tian.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PatmentFallbcakService
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/15 下午5:01
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String ok(Integer id) {
        return "PaymentFallbackService fall back ok";
    }

    @Override
    public String timeout(Integer id) {
        return "PaymentFallbackService fall back timeout";
    }
}
