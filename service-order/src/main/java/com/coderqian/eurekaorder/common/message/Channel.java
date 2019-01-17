package com.coderqian.eurekaorder.common.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author qianliqing
 * @date 2019/1/17 10:32 AM
 * email: qianlq0824@gmail.com
 */

public interface Channel {

    String CONSUMER = "qlqConsumer";

    /**
     * 消息消费者
     * @return SubscribableChannel
     */
    @Input(CONSUMER)
    SubscribableChannel consumer();

    String PRODUCER = "qlqProducer";

    /**
     * 消息生产者
     * @return MessageChannel
     */
    @Output(PRODUCER)
    MessageChannel producer();
}
