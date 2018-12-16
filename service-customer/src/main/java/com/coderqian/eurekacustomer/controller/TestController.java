package com.coderqian.eurekacustomer.controller;

import com.coderqian.eurekacustomer.common.BaseResult;
import com.coderqian.eurekacustomer.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

@RefreshScope
@RestController
@RequestMapping(value = "/test")
@Api(value = "测试", description = "测试模块", position = 1)
public class TestController {

//    @Value("${profile}")
    private String profile;

//    @Value("${mysql}")
    private String mysql;

//    @Value("${redis}")
    private String redis;

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

    @ApiOperation(value = "返回统一的baseResult", notes = "返回统一的baseResult，推荐使用这种方式，所有的返回结果统一用baseResult组装")
    @RequestMapping(value = "/baseresult", method = RequestMethod.GET)
    public BaseResult testBaseResult(@RequestParam(value = "text") String text) {
        return testService.testBaseResult(text);
    }

    @ApiOperation(value = "根据用户id获取用户信息", notes = "根据用户id获取用户信息")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public BaseResult testMybatis(@RequestParam("id") String id) {
        return testService.testMybatis(id);
    }

    @ApiOperation(value = "读取配置文件", notes = "读取配置文件")
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String testConfig() {
        return "mysql:" + mysql + ", redis:" + redis;
    }

    @ApiOperation(value = "测试消息总线", notes = "测试消息总线")
    @RequestMapping(value = "/bus", method = RequestMethod.GET)
    public String testBus() {
        return profile;
    }
}
