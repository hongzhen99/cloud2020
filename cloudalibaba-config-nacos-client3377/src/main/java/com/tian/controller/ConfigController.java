package com.tian.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/18 下午3:22
 */
@RestController
@RefreshScope  //支持动态刷新
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/config/info")
    public String aa(){
        return "端口: "+ serverPort + "信息 " +configInfo;
    }
}
