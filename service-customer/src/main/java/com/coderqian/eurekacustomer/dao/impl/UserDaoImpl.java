package com.coderqian.eurekacustomer.dao.impl;

import com.coderqian.eurekacustomer.dao.UserDao;
import com.coderqian.eurekacustomer.mapper.UserMapper;
import com.coderqian.eurekacustomer.model.entity.UserEntity;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author qianliqing
 * @date 2019-04-21 12:34 AM
 * mail: qianlq0824@gmail.com
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    @CachePut(cacheNames = "user", key = "#user.id")
    public UserEntity insertUser(UserEntity user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    @CachePut(cacheNames = "user", key = "#user.id")
    public UserEntity updateUser(UserEntity user) {
        userMapper.updateUser(user);
        return user;
    }

    @Override
    @Cacheable(cacheNames = "findUserById")
    public UserEntity findUser(String id) {
        return userMapper.findUserById(id);
    }
}
