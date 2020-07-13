package com.tian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @ClassName OrderZKMain
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/13 下午3:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain.class,args);
    }
}
