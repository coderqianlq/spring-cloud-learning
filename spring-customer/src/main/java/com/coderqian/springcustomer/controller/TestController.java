package com.coderqian.springcustomer.controller;

import com.coderqian.springcustomer.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianliqing
 * @date 2018-09-28 下午2:37
 * mail: qianlq0824@gmail.com
 * <p>
 * 测试类
 */

@RestController
@RequestMapping(value = "/customer/test")
@Api(value = "测试", description = "测试模块", position = 1)
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "返回用户输入的结果", notes = "返回用户输入的结果")
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String test(@RequestParam(value = "text") String text) {
        return testService.test(text);
    }

    @ApiOperation(value = "测试全局异常捕获", notes = "测试全局异常捕获")
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public void testException(@RequestParam(value = "text") String text) {
        testService.testException(text);
    }
}
