package com.qianlq.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    private static final String FALLBACK_MESSAGE = "Service call failed";

    @RequestMapping(value = "/fallback")
    public String fallback() {
        return FALLBACK_MESSAGE;
    }
}
