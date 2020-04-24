package com.qianlq.customer.common.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author CoderQian
 * @date 2019/1/17 10:32 AM
 * email: qianlq0824@gmail.com
 */

public interface Channel {

    String CONSUMER = "consumer-test";
    String PRODUCER = "producer-test";

    /**
     * 消息消费者
     *
     * @return SubscribableChannel
     */
    @Input(Channel.CONSUMER)
    SubscribableChannel consumer();

    /**
     * 消息生产者
     *
     * @return MessageChannel
     */
    @Output(Channel.PRODUCER)
    MessageChannel producer();
}
