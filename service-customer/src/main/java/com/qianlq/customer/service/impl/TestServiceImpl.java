package com.qianlq.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianlq.customer.common.BaseResult;
import com.qianlq.customer.common.BaseResultFactory;
import com.qianlq.customer.common.constant.Code;
import com.qianlq.customer.common.exception.BusinessException;
import com.qianlq.customer.common.message.Channel;
import com.qianlq.customer.converter.User2UserDtoMapper;
import com.qianlq.customer.dao.UserDao;
import com.qianlq.customer.mapper.UserMapper;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author CoderQian
 * @date 2018-09-28 下午2:39
 * mail: qianlq0824@gmail.com
 */

@Service
@EnableBinding(Channel.class)
public class TestServiceImpl implements TestService {

    private Logger logger = LogManager.getLogger(TestServiceImpl.class);

    private UserDao userDao;

    private UserMapper userMapper;

    private TestClient testClient;

    private Channel channel;

    public TestServiceImpl(UserDao userDao, UserMapper userMapper, TestClient testClient, Channel channel) {
        this.userDao = userDao;
        this.userMapper = userMapper;
        this.testClient = testClient;
        this.channel = channel;
    }

    @Override
    public String test(String text) {
        return text;
    }

    @Override
    public void testException(String text) throws BusinessException {
        throw new BusinessException(Code.UNDEFINED);
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
    public BaseResult<UserEntity> testMybatis(String id) {
        return BaseResultFactory.createSuccessResult(userMapper.findUserById(id));
    }

    @Override
    public BaseResult<UserEntity> testRedis(String id) {
        return BaseResultFactory.createSuccessResult(userDao.findUser(id));
    }

    @Override
    public BaseResult<PageInfo<UserDto>> testPageHelper(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> users = userMapper.findAll();
        List<UserDto> userDto = User2UserDtoMapper.INSTANCE.users2UserDtos(users);
        PageInfo<UserDto> page = new PageInfo<>(userDto);
        return BaseResultFactory.createSuccessResult(page);
    }

    @Override
    public BaseResult<UserDto> testMapStruct(String id) {
        UserEntity user = userMapper.findUserById(id);
        UserDto dto = User2UserDtoMapper.INSTANCE.user2UserDto(user);
        return BaseResultFactory.createSuccessResult(dto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<UserEntity> addUser(String name, String birth) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setBirth(birth);
        return BaseResultFactory.createSuccessResult(userDao.insertUser(user));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<UserEntity> updateUser(String id, String name, String birth) {
        //判断用户id是否为空，防止mybatis执行全表update
        if (StringUtils.isEmpty(id)) {
            //throw new BusinessException(-1, "用户id为空");
            throw new BusinessException(Code.PARAM_NULL);
        }
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setBirth(birth);
        return BaseResultFactory.createSuccessResult(userDao.updateUser(user));
    }
}
