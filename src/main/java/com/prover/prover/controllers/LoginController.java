package com.prover.prover.controllers;

import com.prover.prover.models.User;
import com.prover.prover.security.CustomUserDetails;
import com.prover.prover.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Admin on 20.05.2017.
 */
@Controller
@RequestMapping()
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid  @ModelAttribute User user, BindingResult bindingResult) throws NoSuchMethodException, MethodArgumentNotValidException {
        if (bindingResult.hasErrors()) throwNotValid(bindingResult);
        userService.save(user);
        return "redirect:/";
    }




    private void throwNotValid(BindingResult bindingResult) throws NoSuchMethodException, MethodArgumentNotValidException {
        throw new MethodArgumentNotValidException(
                new MethodParameter(this.getClass().getDeclaredMethod("registration", User.class, BindingResult.class), 0),
                bindingResult);
    }

}
