package com.qianlq.feignserver.configuration.fallback;

import com.qianlq.feignserver.service.TestCustomerService;
import org.springframework.stereotype.Component;

/**
 * @author qianliqing
 * @date 2018-10-16 下午5:08
 * mail: qianlq0824@gmail.com
 */

@Component
public class HystrixClientFallback implements TestCustomerService {

    @Override
    public String testCustomer(String text) {
        return "失败:" + text;
    }
}
