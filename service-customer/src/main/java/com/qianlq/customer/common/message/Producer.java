package com.qianlq.customer.common.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020-04-02
 */

@EnableBinding(Channel.class)
public class Producer {

    private Logger logger = LogManager.getLogger(Producer.class);

    @Resource
    private Channel channel;

    public void produce(String message) {
        logger.info("发送消息: {}", message);
        channel.producer().send(MessageBuilder.withPayload(message).build());
    }
}
