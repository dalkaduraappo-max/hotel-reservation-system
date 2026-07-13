package com.hotel.booking.exception;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex
                                                        , HttpServletRequest reg){
        log.info("Not Found {}: {}",reg.getRequestURI(),ex.getMessage());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponse(404,"Not Found",ex.getMessage())
        );
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateResource(ResourceNotFoundException ex
            , HttpServletRequest reg) {
        log.info("Duplicate Resource{}: {}", reg.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ErrorResponse(409, "Duplicate Resource", ex.getMessage())
        );
    }
}
