package com.poc.contrainte.validation;

import com.poc.contrainte.errors.ErrorsEnum;
import com.poc.donnee.dto.UserRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequestDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDTO userDTO = (UserRequestDTO) target;
        if (StringUtils.isEmpty(userDTO.getUsername())) {
            errors.rejectValue("username", "username.value.empty", ErrorsEnum.ERR_MCS_USER_USERNAME_EMPTY.getErrorMessage());
        }
        if (StringUtils.isEmpty(userDTO.getPassword())) {
            errors.rejectValue("password", "password.value.empty", ErrorsEnum.ERR_MCS_USER_PASSWORD_EMPTY.getErrorMessage());
        }
    }

}
