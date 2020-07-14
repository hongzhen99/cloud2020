package com.tian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderOpenFeignMain
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/14 下午5:55
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain.class,args);
    }
}
