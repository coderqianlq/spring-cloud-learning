package com.coderqian.eurekacustomer.mapper;

import com.coderqian.eurekacustomer.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-10-02 下午2:31
 * mail: qianlq0824@gmail.com
 */

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 根据用户id查询
     *
     * @param id 用户id
     * @return User
     */
    User findUserById(String id);
}
