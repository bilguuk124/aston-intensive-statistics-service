package com.aston.statisticsservice.controller;

import com.aston.statisticsservice.entity.ErrorBody;
import com.aston.statisticsservice.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class StatisticsControllerAdvice {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ErrorBody> handleValidationException(ValidationException e){
        return ResponseEntity.status(400).body(
                ErrorBody.builder()
                .statusCode(400)
                .message("Validation exception")
                .details(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<ErrorBody> handelThrowable(Throwable e){
        return ResponseEntity.status(500).body(
                ErrorBody.builder()
                        .statusCode(500)
                        .message("Internal Server Error")
                        .details(e.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());
    }
}
