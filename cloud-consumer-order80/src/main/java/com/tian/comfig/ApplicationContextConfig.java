package com.tian.comfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/7/9 15:18
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //授予负载均衡能力  --》   ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
