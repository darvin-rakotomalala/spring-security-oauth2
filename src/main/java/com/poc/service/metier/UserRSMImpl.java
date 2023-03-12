package com.poc.service.metier;

import com.poc.contrainte.errors.ErrorsEnum;
import com.poc.contrainte.errors.FunctionalException;
import com.poc.donnee.domain.User;
import com.poc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserRSMImpl implements UserRSM {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        try {
            log.info("----- getUserById : {}", id);
            Optional<User> userFound = userRepository.findById(id);
            if (userFound.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_ID_NOT_FOUND.getErrorMessage());
            }
            return userFound.get();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable) {
        try {
            log.info("----- getNoteById");
            return userRepository.findAll(pageable);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}
