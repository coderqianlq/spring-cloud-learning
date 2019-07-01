package com.qianlq.eurekacustomer.dao.impl;

import com.qianlq.eurekacustomer.dao.UserDao;
import com.qianlq.eurekacustomer.mapper.UserMapper;
import com.qianlq.eurekacustomer.model.entity.UserEntity;
import org.springframework.cache.annotation.CacheEvict;
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

    /**
     * @CachePut 会把方法的返回值放入缓存中，主要用于数据新增和修改方法。
     */
    @Override
    @CachePut(cacheNames = "users", key = "#user.id")
    public UserEntity insertUser(UserEntity user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    @CachePut(cacheNames = "users", key = "#user.id")
    public UserEntity updateUser(UserEntity user) {
        userMapper.updateUser(user);
        return user;
    }

    /**
     * @Cacheable 方法执行前先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；若没有数据，执行该方法并将方法返回值放进缓存。
     */
    @Override
    @Cacheable(cacheNames = "users", key = "#id")
    public UserEntity findUser(String id) {
        return userMapper.findUserById(id);
    }

    /**
     * @CacheEvict 在方法执行成功后会从缓存中移除相应数据。
     */
    @Override
    @CacheEvict(cacheNames = "users", key = "#id")
    public UserEntity deleteUser(String id) {
        return userMapper.deleteUser(id);
    }
}
