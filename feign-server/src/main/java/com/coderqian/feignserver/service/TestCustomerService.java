package com.coderqian.feignserver.service;

import com.coderqian.feignserver.configuration.fallback.HystrixClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qianliqing
 * @date 2018-10-15 上午9:03
 * mail: qianlq0824@gmail.com
 */

@FeignClient(value = "eureka-customer", fallback = HystrixClientFallback.class)
@Service
public interface TestCustomerService {

    @RequestMapping(value = "/test/result", method = RequestMethod.GET)
    String testCustomer(@RequestParam(value = "text") String text);
}
