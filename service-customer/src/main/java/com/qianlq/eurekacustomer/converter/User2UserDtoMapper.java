package com.qianlq.eurekacustomer.converter;

import com.qianlq.eurekacustomer.model.entity.UserEntity;
import com.qianlq.eurekacustomer.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author qianliqing
 * @date 2019/1/17 2:49 PM
 * email: qianlq0824@gmail.com
 */

@Mapper(componentModel = "spring")
public interface User2UserDtoMapper {

    User2UserDtoMapper INSTANCE = Mappers.getMapper(User2UserDtoMapper.class);

    /**
     * user to userDto
     *
     * @param user 用户
     * @return UserDto
     */
    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "name", source = "user.name"),
            @Mapping(target = "birth", source = "user.birth")
    })
    UserDto user2UserDto(UserEntity user);

    /**
     * user to userDto
     *
     * @param users 用户
     * @return List<UserDTO>
     */
    List<UserDto> users2UserDtos(List<UserEntity> users);
}
