package com.bezkoder.springjwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationFailedResponse onConstraintValidationException(ConstraintViolationException e) {
        ValidationFailedResponse error = new ValidationFailedResponse();
        for (ConstraintViolation violation: e.getConstraintViolations()) {
//            error.getViolations().add(new ResponseErrors(violation.getPropertyPath().toString(), violation.getMessage(), 1000));
            error.setViolations(new ResponseErrors(violation.getPropertyPath().toString(), violation.getMessage(), 1000));
            return error;
        }
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationFailedResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationFailedResponse error = new ValidationFailedResponse();
        for (FieldError fieldError: e.getBindingResult().getFieldErrors()) {
//            error.getViolations().add(new ResponseErrors(fieldError.getField(), fieldError.getDefaultMessage(), 1001));
            error.setViolations(new ResponseErrors(fieldError.getField(), fieldError.getDefaultMessage(), 1001));
        }
        return error;
    }
}
