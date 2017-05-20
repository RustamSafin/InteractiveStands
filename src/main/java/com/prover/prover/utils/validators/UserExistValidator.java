package com.prover.prover.utils.validators;

import com.prover.prover.services.UserService;
import com.prover.prover.utils.validators.annotations.UserExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Admin on 20.05.2017.
 */
@Component
public class UserExistValidator implements ConstraintValidator<UserExist,String> {

    private final UserService userService;

    private boolean exist;

    @Autowired
    public UserExistValidator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void initialize(UserExist userExist) {
        exist = userExist.value();
    }

    @Override
    public boolean isValid(String  username, ConstraintValidatorContext constraintValidatorContext) {
        return exist ? userService.findUserByUsername(username) != null : userService.findUserByUsername(username) == null ;
    }
}
