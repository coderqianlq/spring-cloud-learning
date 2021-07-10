package com.qianlq.core.service.impl;

import com.qianlq.core.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test(String text) {
        return text;
    }
}
