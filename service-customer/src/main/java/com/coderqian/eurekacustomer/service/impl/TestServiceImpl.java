package com.coderqian.eurekacustomer.service.impl;

import com.coderqian.eurekacustomer.common.BaseResult;
import com.coderqian.eurekacustomer.common.BaseResultFactory;
import com.coderqian.eurekacustomer.common.constant.Code;
import com.coderqian.eurekacustomer.common.exception.BusinessException;
import com.coderqian.eurekacustomer.entity.User;
import com.coderqian.eurekacustomer.mapper.UserMapper;
import com.coderqian.eurekacustomer.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public BaseResult testPageHelper(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(users);
        return BaseResultFactory.createSuccessResult(page);
    }
}
