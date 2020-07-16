package com.tian.controller;

import com.tian.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/16 下午8:00
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/send")
    public String sendMsg(){
        return iMessageProvider.msg();
    }
}
