package com.poc.service.applicatif;

import com.poc.donnee.dto.UserDTO;
import com.poc.donnee.dto.UserRequestDTO;
import com.poc.mapper.UserMapper;
import com.poc.mapper.UserRequestMapper;
import com.poc.service.metier.UserCUDSM;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCUDSAImpl implements UserCUDSA {

    private final UserCUDSM userCUDSM;
    private final UserRequestMapper userRequestMapper;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    @Override
    public UserDTO saveUser(UserRequestDTO userRequest) {
        var user = userRequestMapper.toDO(userRequest);
        user.setPassword(encoder.encode(userRequest.getPassword()));
        return userMapper.toDTO(userCUDSM.saveUser(user));
    }

    @Override
    public void deleteUserById(Long id) {
        userCUDSM.deleteUserById(id);
    }

}
