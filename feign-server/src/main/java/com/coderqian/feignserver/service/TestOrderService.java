package com.coderqian.feignserver.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qianliqing
 * @date 2018-10-15 上午10:28
 * mail: qianlq0824@gmail.com
 */

@FeignClient(value = "eureka-order")
public interface TestOrderService {

    @RequestMapping(value = "/test/result", method = RequestMethod.GET)
    String testOrder(@RequestParam(value = "text") String text);
}
