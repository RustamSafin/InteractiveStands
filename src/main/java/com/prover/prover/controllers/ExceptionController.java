package com.prover.prover.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Admin on 20.05.2017.
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public List<FieldError> processValidationError(MethodArgumentNotValidException ex, HttpServletResponse response) {
        response.setStatus(200);
        BindingResult result = ex.getBindingResult();
        return result.getFieldErrors();
    }
}
