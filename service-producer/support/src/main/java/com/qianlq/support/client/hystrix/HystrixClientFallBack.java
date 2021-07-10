package com.qianlq.support.client.hystrix;

import com.qianlq.support.client.TestClient;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallBack implements TestClient {

    @Override
    public String test(String text) {
        return "服务调用失败: " + text;
    }
}
