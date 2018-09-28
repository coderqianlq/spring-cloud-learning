package com.coderqian.springorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianliqing
 * @date 2018-09-28 下午7:56
 * mail: qianlq0824@gmail.com
 */

@RestController
@RequestMapping(value = "/test")
@Api(value = "测试", description = "测试模块", position = 1)
public class TestController {

    @ApiOperation(value = "返回用户输入的结果", notes = "返回用户输入的结果")
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String test(String text) {
        return text;
    }
}
