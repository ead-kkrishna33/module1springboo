package com.coding.module1introduction.advice;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private LocalDateTime timeStamp;
    private String errorMessage;
    private HttpStatus status;

    public ApiError() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiError(LocalDateTime timeStamp, String errorMessage, HttpStatus status) {
        this();
        this.timeStamp = timeStamp;
        this.errorMessage = errorMessage;
        this.status = status;
    }
}
