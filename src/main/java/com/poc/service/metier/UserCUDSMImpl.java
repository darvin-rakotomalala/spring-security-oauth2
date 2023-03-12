package com.poc.service.metier;

import com.poc.donnee.domain.User;
import com.poc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserCUDSMImpl implements UserCUDSM {

    private final UserRepository userRepository;
    private final UserRSM userRSM;

    @Override
    public User saveUser(User user) {
        try {
            log.info("----- saveUser");
            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        try {
            log.info("----- deleteUserById : {}", id);
            var userFound = userRSM.getUserById(id);
            userRepository.deleteById(userFound.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}
