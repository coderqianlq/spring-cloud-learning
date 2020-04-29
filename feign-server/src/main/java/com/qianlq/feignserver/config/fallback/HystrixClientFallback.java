package com.qianlq.feignserver.config.fallback;

import com.qianlq.feignserver.service.TestCustomerService;
import org.springframework.stereotype.Component;

/**
 * @author CoderQian
 * @date 2018-10-16 下午5:08
 * @concat <a href="mailto:qianlq0824@gmail.com">qianlq0824@gmail.com</a>
 */

@Component
public class HystrixClientFallback implements TestCustomerService {

    @Override
    public String testCustomer(String text) {
        return "失败:" + text;
    }
}
