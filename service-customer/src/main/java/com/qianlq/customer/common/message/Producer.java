package com.qianlq.customer.common.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding(Channel.class)
public class Producer {

    private final Logger LOGGER = LogManager.getLogger(Producer.class);

    @Resource
    private Channel channel;

    public void produce(String message) {
        LOGGER.info("发送消息: {}", message);
        channel.producer().send(MessageBuilder.withPayload(message).build());
    }
}
