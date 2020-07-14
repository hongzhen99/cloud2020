package com.tian.service;

import com.tian.entity.CommonResult;
import com.tian.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName ProviderService
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/14 下午5:57
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentOpenFeignService {

    @GetMapping(value = "/payment/create/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
