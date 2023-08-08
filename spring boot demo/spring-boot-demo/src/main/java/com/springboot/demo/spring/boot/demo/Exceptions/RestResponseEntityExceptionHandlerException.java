package com.springboot.demo.spring.boot.demo.Exceptions;

import com.springboot.demo.spring.boot.demo.entity.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice // will invoke this call for any exception in all the controller
@ResponseStatus
public class RestResponseEntityExceptionHandlerException extends ResponseEntityExceptionHandler {

    // create the methods to handle different kinds of exceptions

    @ExceptionHandler(DepartmentNotFoundException.class) //  handle only department not found exception
    public ResponseEntity<ErrorMessageResponse> departmentNotFoundException(DepartmentNotFoundException exception,
                                                                            WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessageResponse.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .message(exception.getMessage())
                        .timeStamp(Instant.now())
                        .build());
    }

}
