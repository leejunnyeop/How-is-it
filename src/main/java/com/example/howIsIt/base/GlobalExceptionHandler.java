package com.example.howIsIt.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity.accepted().body("Valid : " + methodArgumentNotValidException.getMessage());
    }
}
