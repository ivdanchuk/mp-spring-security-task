package com.example.securitytask.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleException(Exception ex, HttpServletRequest request) {
        return new ResponseEntity<>(Error.builder()
                .message(ex.getLocalizedMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
