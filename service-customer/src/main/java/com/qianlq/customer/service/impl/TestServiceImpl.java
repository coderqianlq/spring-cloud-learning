package com.qianlq.customer.service.impl;

import com.qianlq.customer.common.BaseResult;
import com.qianlq.customer.common.BaseResultFactory;
import com.qianlq.customer.common.constant.Code;
import com.qianlq.customer.common.exception.BusinessException;
import com.qianlq.customer.common.message.Channel;
import com.qianlq.customer.converter.User2UserDtoMapper;
import com.qianlq.customer.model.dto.UserDto;
import com.qianlq.customer.model.entity.UserEntity;
import com.qianlq.customer.service.TestService;
import com.qianlq.support.client.TestClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author CoderQian
 * @date 2018-09-28 下午2:39
 * mail: qianlq0824@gmail.com
 */

@Service
@EnableBinding(Channel.class)
public class TestServiceImpl implements TestService {

    private Logger logger = LogManager.getLogger(TestServiceImpl.class);

    private TestClient testClient;

    private Channel channel;

    public TestServiceImpl(TestClient testClient, Channel channel) {
        this.testClient = testClient;
        this.channel = channel;
    }

    @Override
    public String test(String text) {
        return text;
    }

    @Override
    public void testException(String text) throws BusinessException {
        throw new BusinessException(text);
    }

    @Override
    public BaseResult<String> testBaseResult(String text) {
        logger.info("日志测试：{}", text);
        return new BaseResult<>(Code.SUCCESS, text);
    }

    @Override
    public BaseResult<String> testClient(String text) {
        return new BaseResult<>(Code.SUCCESS, testClient.test(text));
    }

    @Override
    public void producer(String message) {
        logger.info("发送消息: {}", message);
        channel.producer().send(MessageBuilder.withPayload(message).build());
    }

    @StreamListener(Channel.CONSUMER)
    public void consume(String message) {
        logger.info("接收消息: {}", message);
    }

    @Override
    public BaseResult<UserDto> testMapStruct() {
        UserEntity user = new UserEntity("21851123", "CoderQian", "1995-08-24");
        UserDto dto = User2UserDtoMapper.INSTANCE.user2UserDto(user);
        return BaseResultFactory.createSuccessResult(dto);
    }

}
