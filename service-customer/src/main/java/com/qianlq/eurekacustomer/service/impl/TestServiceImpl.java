package com.qianlq.eurekacustomer.service.impl;

import com.qianlq.eurekacustomer.common.BaseResult;
import com.qianlq.eurekacustomer.common.BaseResultFactory;
import com.qianlq.eurekacustomer.common.constant.Code;
import com.qianlq.eurekacustomer.common.exception.BusinessException;
import com.qianlq.eurekacustomer.converter.User2UserDtoMapper;
import com.qianlq.eurekacustomer.dao.UserDao;
import com.qianlq.eurekacustomer.mapper.UserMapper;
import com.qianlq.eurekacustomer.model.dto.UserDto;
import com.qianlq.eurekacustomer.model.entity.UserEntity;
import com.qianlq.eurekacustomer.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-09-28 下午2:39
 * mail: qianlq0824@gmail.com
 */

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @Override
    public String test(String text) {
        return text;
    }

    @Override
    public void testException(String text) throws BusinessException {
        throw new BusinessException(Code.UNDEFINED);
    }

    @Override
    public BaseResult testBaseResult(String text) {
        log.info("日志测试：{}", text);
        return new BaseResult(text);
    }

    @Override
    public BaseResult testMybatis(String id) {
        return BaseResultFactory.createSuccessResult(userMapper.findUserById(id));
    }

    @Override
    public BaseResult testRedis(String id) {
        return BaseResultFactory.createSuccessResult(userDao.findUser(id));
    }

    @Override
    public BaseResult testPageHelper(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> users = userMapper.findAll();
        List<UserDto> userDto = User2UserDtoMapper.INSTANCE.users2UserDtos(users);
        PageInfo<UserDto> page = new PageInfo<>(userDto);
        return BaseResultFactory.createSuccessResult(page);
    }

    @Override
    public BaseResult testMapStruct(String id) {
        UserEntity user = userMapper.findUserById(id);
        UserDto dto = User2UserDtoMapper.INSTANCE.user2UserDto(user);
        return BaseResultFactory.createSuccessResult(dto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult addUser(String name, String birth) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setBirth(birth);
        return BaseResultFactory.createSuccessResult(userDao.insertUser(user));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult updateUser(String id, String name, String birth) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setBirth(birth);
        return BaseResultFactory.createSuccessResult(userDao.updateUser(user));
    }
}
