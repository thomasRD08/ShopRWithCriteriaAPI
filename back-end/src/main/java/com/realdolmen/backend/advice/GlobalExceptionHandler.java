package com.realdolmen.backend.advice;

import com.realdolmen.backend.advice.exception.CustomExceptionHandler;
import com.realdolmen.backend.advice.exception.CustomNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity handleNotFoundException(CustomNotFoundException e) {
        log.error(e.getMessage());
        Map<String, Object> msg = new HashMap<>();
        msg.put("message", e.getMessage());
        msg.put("httpStatus", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity handleException(CustomExceptionHandler e) {
        log.error(e.getMessage());
        Map<String, Object> msg = new HashMap<>();
        msg.put("message", e.getMessage());
        msg.put("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
    }
}
