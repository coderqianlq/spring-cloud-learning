package com.qianlq.customer.common.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020-04-02
 */

@EnableBinding(Channel.class)
public class Consumer {

    private Logger logger = LogManager.getLogger(Consumer.class);

    @StreamListener(Channel.CONSUMER)
    public void consume(String message) {
        logger.info("接收消息: {}", message);
    }
}

