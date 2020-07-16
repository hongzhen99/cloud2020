package com.tian.service.impl;

import com.tian.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName IMessageProviderImpl
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/16 下午7:53
 */
@EnableBinding(Source.class)//定义消息通道
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String msg() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("********uuid = "+uuid);
        return uuid;
    }
}
