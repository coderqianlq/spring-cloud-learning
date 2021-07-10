package com.qianlq.consulserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ConsulController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "health";
    }
}
