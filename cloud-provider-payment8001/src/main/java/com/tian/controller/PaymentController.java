package com.tian.controller;

import com.tian.entity.CommonResult;
import com.tian.entity.Payment;
import com.tian.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/7/8 21:35
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.createPayment(payment);
        log.info("插入结果==============" + result);
        if (result > 0){
            return new CommonResult(200,"成功"+serverPort,result);
        } else {

            return new CommonResult(500,"失败",result);
        }
    }
    @GetMapping(value = "/payment/create/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("插入结果==============" + paymentById);
        if (paymentById != null ){
            return new CommonResult(200,"查询成功"+serverPort,paymentById);
        } else {
            return new CommonResult(500,"没有对应记录",null);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String a : services){
            log.info("××××element: "+a);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance a : instances){
            log.info(a.getInstanceId()+"\t"+a.getUri()+"\t"+a.getHost()+":"+a.getPort());
        }

        return this.discoveryClient;
    }
}
