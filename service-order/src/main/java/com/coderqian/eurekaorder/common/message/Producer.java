package com.coderqian.eurekaorder.common.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author qianliqing
 * @date 2019/1/17 10:35 AM
 * email: qianlq0824@gmail.com
 */

@Slf4j
@EnableBinding(Channel.class)
public class Producer {

    @Resource
    private Channel channel;

    public void produce(String message) {
        log.info("发送消息：{}", message);
        channel.producer().send(MessageBuilder.withPayload(message).build());
    }
}
