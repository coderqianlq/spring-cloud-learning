package com.coderqian.eurekacustomer.service;

import com.coderqian.eurekacustomer.common.BaseResult;

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
     * @return String
     */
    String test(String text);

    /**
     * 测试接口
     *
     * @param text 测试数据
     * @return void
     */
    void testException(String text);

    /**
     * 测试接口
     *
     * @param text 测试数据
     * @return BaseResult
     */
    BaseResult testBaseResult(String text);

    /**
     * 测试mybatis接口
     *
     * @param id 用户id
     * @return BaseResult
     */
    BaseResult testMybatis(String id);

    /**
     * 测试Mybatis分页插件
     *
     * @param pageNum  当前页码
     * @param pageSize 每页长度
     * @return BaseResult
     */
    BaseResult testPageHelper(Integer pageNum, Integer pageSize);
}
