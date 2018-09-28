package com.coderqian.springcustomer.service;

/**
 * @author qianliqing
 * @date 2018-09-28 下午2:38
 * mail: qianlq0824@gmail.com
 */

public interface TestService {

    /**
     * 测试接口
     *
     * @param text 测试数据
     * @return
     */
    String test(String text);

    /**
     * 测试接口
     *
     * @param text 测试数据
     * @return
     */
    void testException(String text);
}
