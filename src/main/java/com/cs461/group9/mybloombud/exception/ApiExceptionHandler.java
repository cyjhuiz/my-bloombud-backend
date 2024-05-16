package com.cs461.group9.mybloombud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleApiGenericException(GenericException genericException) {
        return new ResponseEntity<>(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleApiBadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<>(badRequestException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleApiNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<>(notFoundException, HttpStatus.NOT_FOUND);
    }
}
