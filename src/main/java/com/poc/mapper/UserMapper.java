package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.donnee.domain.User;
import com.poc.donnee.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends DtoMapper<UserDTO, User> {

}
