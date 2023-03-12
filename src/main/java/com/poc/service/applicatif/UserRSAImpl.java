package com.poc.service.applicatif;

import com.poc.donnee.dto.UserDTO;
import com.poc.mapper.UserMapper;
import com.poc.service.metier.UserRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRSAImpl implements UserRSA {

    private final UserRSM userRSM;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.toDTO(userRSM.getUserById(id));
    }

    @Override
    public HelpPage<UserDTO> getAllUsers(Pageable pageable) {
        return userMapper.toDTO(userRSM.findAllUsers(pageable), pageable);
    }

}
