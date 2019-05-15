package com.qianlq.eurekacustomer.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qianliqing
 * @date 2018-10-02 下午3:15
 * mail: qianlq0824@gmail.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {

    @Value("${profile}")
    private String profile;

    @Test
    public void testConfig() {
        System.out.println("profile: " + profile);
    }
}
