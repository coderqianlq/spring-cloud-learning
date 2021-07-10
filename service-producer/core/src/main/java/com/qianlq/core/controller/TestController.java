package com.qianlq.core.controller;

import com.qianlq.core.service.TestService;
import com.qianlq.support.client.TestClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "test-controller", tags = "测试模块")
public class TestController implements TestClient {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @Override
    @ApiOperation(value = "测试方法", notes = "返回测试数据", response = String.class)
    public String test(@ApiParam(value = "测试数据", required = true) @RequestParam(value = "text") String text) {
        return testService.test(text);
    }
}
