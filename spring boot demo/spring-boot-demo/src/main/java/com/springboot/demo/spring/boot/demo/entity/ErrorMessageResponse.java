package com.springboot.demo.spring.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageResponse {
    private HttpStatus httpStatus;
    private String message;
    private Instant timeStamp;
}
