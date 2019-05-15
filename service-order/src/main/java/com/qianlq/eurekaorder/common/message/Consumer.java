package com.qianlq.eurekaorder.common.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author qianliqing
 * @date 2019/1/17 10:33 AM
 * email: qianlq0824@gmail.com
 */

@Slf4j
@EnableBinding(Channel.class)
public class Consumer {

    @StreamListener(Channel.CONSUMER)
    public void consume(String message) {
        log.info("接收消息：{}", message);
    }
}
