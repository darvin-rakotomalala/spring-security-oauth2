package com.poc.service.applicatif;

import com.poc.donnee.dto.UserDTO;
import com.poc.donnee.dto.UserRequestDTO;

public interface UserCUDSA {
    UserDTO saveUser(UserRequestDTO user);
    void deleteUserById(Long id);
}
