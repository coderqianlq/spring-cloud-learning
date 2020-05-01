package com.qianlq.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020/5/1
 */

@RestController
public class FallbackController {

    private static final String FALLBACK_MESSAGE = "Service call failed";

    @RequestMapping("/fallback")
    public String fallback() {
        return FALLBACK_MESSAGE;
    }
}
