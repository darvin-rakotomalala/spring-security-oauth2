package com.poc.service.metier;

import com.poc.donnee.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRSM {
    User getUserById(Long id);
    Page<User> findAllUsers(Pageable pageable);
}
