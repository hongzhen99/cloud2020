package com.tian.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/14 下午8:57
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "=> paymentInfo_ok,id: " + id;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName() + "=> paymentInfo_Timeout,id: " + id + "耗时(s): " + time;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池: " + Thread.currentThread().getName() + "=> paymentInfo_Timeout,id: " + id + " 超时/(ㄒoㄒ)/~~";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback" ,commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "1000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("=======id不能为负数");
        }
        String idStr = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"       流水号: = "+ idStr;
    }
    public String  paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数 ====="+id;
    }
}
