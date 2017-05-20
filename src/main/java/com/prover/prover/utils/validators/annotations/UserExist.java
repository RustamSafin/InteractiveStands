package com.prover.prover.utils.validators.annotations;

import com.prover.prover.utils.validators.UserExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Admin on 20.05.2017.
 */
@Documented
@Constraint(validatedBy = UserExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserExist {

    boolean value() default true;

    String message() default "user";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
