package com.qianlq.eurekacustomer.service;

import com.qianlq.eurekacustomer.common.BaseResult;

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
     * 测试redis接口
     *
     * @param id 用户id
     * @return BaseResult
     */
    BaseResult testRedis(String id);

    /**
     * 测试Mybatis分页插件
     *
     * @param pageNum  当前页码
     * @param pageSize 每页长度
     * @return BaseResult
     */
    BaseResult testPageHelper(Integer pageNum, Integer pageSize);

    /**
     * 测试MapStruct
     *
     * @param id 用户id
     * @return BaseResult
     */
    BaseResult testMapStruct(String id);

    /**
     * 新增用户
     *
     * @param name  姓名
     * @param birth 出生日期
     * @return BaseResult
     */
    BaseResult addUser(String name, String birth);

    /**
     * 更新用户
     *
     * @param id    id
     * @param name  姓名
     * @param birth 出生日期
     * @return BaseResult
     */
    BaseResult updateUser(String id, String name, String birth);
}
