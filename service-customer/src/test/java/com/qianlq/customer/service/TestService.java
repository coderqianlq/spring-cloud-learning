package com.qianlq.customer.service;

import com.qianlq.customer.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-01
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        System.out.println(userMapper.findUserById("1"));
    }
}
