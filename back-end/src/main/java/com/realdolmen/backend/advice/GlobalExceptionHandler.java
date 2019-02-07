package com.realdolmen.backend.advice;

import com.realdolmen.backend.advice.exception.AlreadyExistsException;
import com.realdolmen.backend.advice.exception.NotFoundException;
import com.realdolmen.backend.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity handleException(Exception e) {
//        return buildResponseEntity("Something unexpected went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return buildResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleAlreadyExistsException(AlreadyExistsException e) {
        return buildResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleBadRequest(MethodArgumentNotValidException e) {
        List<String> messages = e.getBindingResult().getAllErrors().stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return buildResponseEntity(messages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException e) {
        return buildResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorDto> buildResponseEntity(String message, HttpStatus httpStatus) {
        log.error(message);
        ErrorDto errorDto = ErrorDto.builder()
                .message(message)
                .httpStatus(httpStatus.value())
                .build();
        return ResponseEntity.status(httpStatus)
                .body(errorDto);
    }

    private ResponseEntity<ErrorDto> buildResponseEntity(List<String> messages, HttpStatus httpStatus) {
        messages.forEach(log::error);
        ErrorDto errorDto = ErrorDto.builder()
                .messages(messages)
                .httpStatus(httpStatus.value())
                .build();
        return ResponseEntity.status(httpStatus)
                .body(errorDto);
    }
}
