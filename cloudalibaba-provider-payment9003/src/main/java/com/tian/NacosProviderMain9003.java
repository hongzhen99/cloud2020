package com.tian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName NacosProviderMain9003
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/20 下午1:01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9003.class,args);
    }

}
