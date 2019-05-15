package com.qianlq.feignserver.controller;

import com.qianlq.feignserver.service.TestCustomerService;
import com.qianlq.feignserver.service.TestOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianliqing
 * @date 2018-10-15 上午9:02
 * mail: qianlq0824@gmail.com
 */

@RestController
public class TestController {

    @Autowired
    private TestCustomerService testCustomerService;

    @Autowired
    private TestOrderService testOrderService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(@RequestParam(value = "text") String text) {
        return text;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getCustomer(@RequestParam(value = "text") String text) {
        return testCustomerService.testCustomer(text);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String getOrder(@RequestParam(value = "text") String text) {
        return testOrderService.testOrder(text);
    }

}
