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
    @CachePut(cacheNames = "user")
    public UserEntity insertUser(String name, String birth) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setBirth(birth);
        userMapper.insertUser(user);
        user.setId(user.getId());
        return user;
    }

    @Override
    @Cacheable(cacheNames = "findUserById")
    public UserEntity findUser(String id) {
        return userMapper.findUserById(id);
    }
}
