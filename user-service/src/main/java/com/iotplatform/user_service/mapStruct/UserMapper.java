package com.iotplatform.user_service.mapStruct;

import com.iotplatform.user_service.dto.UserDto;
import com.iotplatform.user_service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

}
