package com.qianlq.consulserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CoderQian
 * @date 2019-01-07 6:02 PM
 * @concat <a href="mailto:qianlq0824@gmail.com">qianlq0824@gmail.com</a>
 */

@RestController
@RequestMapping("/")
public class ConsulController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "health";
    }
}
