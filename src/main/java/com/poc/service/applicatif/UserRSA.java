package com.poc.service.applicatif;

import com.poc.donnee.dto.UserDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface UserRSA {
    UserDTO getUserById(Long id);
    HelpPage<UserDTO> getAllUsers(Pageable pageable);
}
