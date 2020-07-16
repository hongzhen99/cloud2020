package com.tian.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName MessaheConsumerController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/16 下午8:16
 */
@Component
@EnableBinding(Sink.class)
public class MessageConsumerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者一号收到的消息为:" + message.getPayload() + "\t port: " + serverPort);
    }
}
