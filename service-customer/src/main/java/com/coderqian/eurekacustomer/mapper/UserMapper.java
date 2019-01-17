package com.coderqian.eurekacustomer.mapper;

import com.coderqian.eurekacustomer.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<UserEntity> findAll();

    /**
     * 根据用户id查询
     *
     * @param id 用户id
     * @return User
     */
    UserEntity findUserById(@Param("id") String id);
}
