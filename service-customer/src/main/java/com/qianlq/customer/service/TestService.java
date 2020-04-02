package com.qianlq.customer.service;

import com.github.pagehelper.PageInfo;
import com.qianlq.customer.common.BaseResult;
import com.qianlq.customer.model.dto.UserDto;
import com.qianlq.customer.model.entity.UserEntity;

/**
 * @author CoderQian
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
     * @return BaseResult<String>
     */
    BaseResult<String> testBaseResult(String text);

    /**
     * 测试服务间调用
     *
     * @param text 测试数据
     * @return BaseResult<String>
     */
    BaseResult<String> testClient(String text);

    /**
     * 测试消息中间件
     *
     * @param message 消息内容
     */
    void producer(String message);

    /**
     * 测试mybatis接口
     *
     * @param id 用户id
     * @return BaseResult<UserEntity>
     */
    BaseResult<UserEntity> testMybatis(String id);

    /**
     * 测试redis接口
     *
     * @param id 用户id
     * @return BaseResult<UserEntity>
     */
    BaseResult<UserEntity> testRedis(String id);

    /**
     * 测试Mybatis分页插件
     *
     * @param pageNum  当前页码
     * @param pageSize 每页长度
     * @return BaseResult<PageInfo < UserDto>>
     */
    BaseResult<PageInfo<UserDto>> testPageHelper(Integer pageNum, Integer pageSize);

    /**
     * 测试MapStruct
     *
     * @param id 用户id
     * @return BaseResult<UserDto>
     */
    BaseResult<UserDto> testMapStruct(String id);

    /**
     * 新增用户
     *
     * @param name  姓名
     * @param birth 出生日期
     * @return BaseResult<UserEntity>
     */
    BaseResult<UserEntity> addUser(String name, String birth);

    /**
     * 更新用户
     *
     * @param id    id
     * @param name  姓名
     * @param birth 出生日期
     * @return BaseResult<UserEntity>
     */
    BaseResult<UserEntity> updateUser(String id, String name, String birth);
}
