package com.example.userregister.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Properties;

@RestControllerAdvice
public class UserException {

    @ExceptionHandler(RuntimeException.class)
    public Properties handle(RuntimeException exception){
        Properties props = new Properties();
        props.setProperty("message", exception.getMessage());
        return  props;
    }

}
