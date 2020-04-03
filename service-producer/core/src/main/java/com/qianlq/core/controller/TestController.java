package com.qianlq.core.controller;

import com.qianlq.api.v2.api.TestApi;
import com.qianlq.core.service.TestService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020-04-01
 */

@RestController
public class TestController implements TestApi {

    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @Override
    public String test(@ApiParam(value = "测试数据", required = true) @RequestParam(value = "text") String text) {
        return testService.test(text);
    }
}
