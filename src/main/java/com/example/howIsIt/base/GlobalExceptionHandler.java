package com.example.howIsIt.base;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    public ResponseEntity<Object> buildErrorResponse(String massage, List<String> details, HttpStatus statues){
        ErrorResponse errorResponse = new ErrorResponse(massage, details);
        return new ResponseEntity<>(errorResponse, statues);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> validList = methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());


        return buildErrorResponse("잘못된 요청입니다.",validList,HttpStatus.BAD_REQUEST);
    }

    // 커스텀 예외처리

    @ExceptionHandler(ProfileBoardNotFoundException.class)
    public ResponseEntity<Object> handlerProfileBoardNotFountException(ProfileBoardNotFoundException profileBoardNotFoundException){
        return buildErrorResponse("프로그램 실행 중 에러가 발생했습니다",
                Collections.singletonList(profileBoardNotFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    // 전역 예외처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerGeneralException(Exception exception){
        return buildErrorResponse("서버 실행 중 에러가 발생했습니다",
                Collections.singletonList(exception.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
