package com.tian.controller;

import com.tian.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentHystrixController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/14 下午9:02
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_ok(id);
        log.info("result========"+s);
        return s;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_Timeout(id);
        log.info("result========"+s);
        return s;
    }


    //服务熔断
    @GetMapping("/payment/hystrix/cir/{id}")
    public String cir(@PathVariable("id") Integer id){
        log.info(paymentService.paymentCircuitBreaker(id));
        return paymentService.paymentCircuitBreaker(id);
    }
}
