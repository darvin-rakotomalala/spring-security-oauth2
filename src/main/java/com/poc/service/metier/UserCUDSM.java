package com.poc.service.metier;

import com.poc.donnee.domain.User;

public interface UserCUDSM {
    User saveUser(User user);
    void deleteUserById(Long id);
}
