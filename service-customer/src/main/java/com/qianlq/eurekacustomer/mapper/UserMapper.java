package com.qianlq.eurekacustomer.mapper;

import com.qianlq.eurekacustomer.model.entity.UserEntity;
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

    /**
     * 插入用户，返回用户id
     * 需要注意的是在mapper接口中不能使用@Param("")绑定传入实体参数，这样主键会绑定到新建的实体中。
     * 如@Param("user") UserEntity user主键会绑定到新建的实体，即getId() = null。
     *
     * @param user 用户实体
     * @return Long
     */
    Long insertUser(UserEntity user);

    /**
     * 更新用户
     *
     * @param user 用户实体
     * @return Long
     */
    Long updateUser(UserEntity user);

    /**
     * 删除用户(推荐逻辑删除)
     *
     * @param id 用户id
     * @return Long
     */
    UserEntity deleteUser(@Param("id") String id);
}
