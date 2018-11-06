package com.coderqian.eurekaorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qianliqing
 * @date 2018-09-28 下午7:56
 * mail: qianlq0824@gmail.com
 */

@RestController
@RequestMapping(value = "/test")
@Api(value = "测试", description = "测试模块", position = 1)
public class TestController {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "返回用户输入的结果", notes = "返回用户输入的结果")
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String test(@RequestParam(value = "text") String text) {
        return text;
    }

    @ApiOperation(value = "测试服务链路追踪", notes = "测试服务链路追踪")
    @RequestMapping(value = "/zipkin", method = RequestMethod.GET)
    public String testCustomer(@RequestParam(value = "text") String text) {
        return restTemplate.getForObject("http://service-customer/test/result?text=" + text, String.class);
    }
}
