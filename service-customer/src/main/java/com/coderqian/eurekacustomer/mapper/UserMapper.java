package com.coderqian.eurekacustomer.mapper;

import com.coderqian.eurekacustomer.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qianliqing
 * @date 2018-10-02 下午2:31
 * mail: qianlq0824@gmail.com
 */

@Mapper
public interface UserMapper {

    /**
     * 根据用户id查询
     *
     * @param id 用户id
     * @return
     */
    User findUserById(String id);
}
