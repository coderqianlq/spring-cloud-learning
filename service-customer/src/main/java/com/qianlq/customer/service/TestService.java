package com.qianlq.customer.service;

import com.qianlq.customer.common.BaseResult;
import com.qianlq.customer.model.dto.UserDto;

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
     * 测试MapStruct
     *
     * @return BaseResult<UserDto>
     */
    BaseResult<UserDto> testMapStruct();

}
