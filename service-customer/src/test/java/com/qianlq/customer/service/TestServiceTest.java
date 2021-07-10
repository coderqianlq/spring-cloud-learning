package com.qianlq.customer.service;

import com.qianlq.customer.common.exception.BusinessException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        Assert.assertEquals(testService.test("hello"), "hello");
    }

    @Test(expected = BusinessException.class)
    public void testException() {
        testService.testException("test exception");
    }
}
