package com.qianlq.customer.common.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(Channel.class)
public class Consumer {

    private final Logger LOGGER = LogManager.getLogger(Consumer.class);

    @StreamListener(Channel.CONSUMER)
    public void consume(String message) {
        LOGGER.info("接收消息: {}", message);
    }
}

