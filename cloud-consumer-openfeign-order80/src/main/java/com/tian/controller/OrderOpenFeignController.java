package com.tian.controller;

import com.tian.entity.CommonResult;
import com.tian.entity.Payment;
import com.tian.service.PaymentOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderOpenFeignController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/14 下午6:03
 */
@RestController
@Slf4j
public class OrderOpenFeignController {
    @Resource
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping(value = "/payment/create/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentOpenFeignService.getPaymentById(id);
    }

}
