package com.qianlq.support.client;

import com.qianlq.support.client.hystrix.HystrixClientFallBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020-04-01
 */


@Api(value = "test-client", tags = {"测试接口"})
@FeignClient(name = "service-producer", fallback = HystrixClientFallBack.class)
public interface TestClient {

    /**
     * 测试方法
     *
     * @param text 测试数据
     * @return text
     */
    @ApiOperation(value = "提供给Customer调用的测试方法", notes = "测试方法")
    @RequestMapping(value = "/service-producer/v2/test", method = RequestMethod.GET)
    String test(@RequestParam(value = "text") String text);
}
