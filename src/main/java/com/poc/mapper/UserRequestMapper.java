package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.donnee.domain.User;
import com.poc.donnee.dto.UserRequestDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserRequestMapper extends DtoMapper<UserRequestDTO, User> {

}
