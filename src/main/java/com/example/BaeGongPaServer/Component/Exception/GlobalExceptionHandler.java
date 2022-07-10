package com.example.BaeGongPaServer.Component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(Exception ex) {

        log.error("handleException : " + ex.getMessage());
        System.out.println("handleException : " + ex);
        System.out.println("handleException : " + ex.getMessage());

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(401);
        apiResponse.setResult(ex);
        apiResponse.setMessage(ex.getMessage());

        return apiResponse;
    }
}

