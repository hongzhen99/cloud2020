package com.tian.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/16 上午10:26
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;



    @GetMapping("/config/info")
    public String aa(){
        return "端口: "+ serverPort + "信息 " +configInfo;
    }
}
