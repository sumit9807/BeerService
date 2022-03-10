package com.learningmicroservices.beerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AdviceExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationExceptionHandler(ConstraintViolationException e){
        List<String> list = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(error-> list.add(error.toString()));
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
}
