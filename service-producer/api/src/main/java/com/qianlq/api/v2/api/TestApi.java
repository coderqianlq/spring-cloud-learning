package com.qianlq.api.v2.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020-04-01
 */


@RequestMapping(value = "/service-producer/v2")
@Api(value = "test-api", tags = {"测试接口"})
public interface TestApi {

    /**
     * 测试方法
     *
     * @param text 测试数据
     * @return text
     */
    @ApiOperation(value = "提供给Customer调用的测试方法", notes = "测试方法")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test(@RequestParam(value = "text") String text);
}
