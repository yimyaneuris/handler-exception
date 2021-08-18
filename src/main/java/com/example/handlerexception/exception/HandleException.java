package com.example.handlerexception.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

    Logger logger = LoggerFactory.getLogger(HandleException.class);

    @ExceptionHandler(value = { InvalidInputException.class })
    public ResponseEntity<?> handleInvalidInputException(InvalidInputException e) {
        logger.error("Invalid input exception: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = { UnauthorizedException.class })
    public ResponseEntity<?> handlerUnauthorizedException(UnauthorizedException e) {
        logger.error("Unauthorized Exception: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = { BusinessException.class })
    public ResponseEntity<?> handlerBusinessException(BusinessException e) {
        logger.error("Business Exception: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<?> handlerException(Exception e) {
        logger.error("Exception General : " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
