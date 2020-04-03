package com.qianlq.core.service.impl;

import com.qianlq.core.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020-04-01
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test(String text) {
        return text;
    }
}
