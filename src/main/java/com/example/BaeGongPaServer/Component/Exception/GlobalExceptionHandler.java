package com.example.BaeGongPaServer.Component.Exception;

import com.example.BaeGongPaServer.Component.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResponse handleException(Exception ex) {

        log.error("handleException : " + ex.getMessage());
        System.out.println("handleException : " + ex);
        System.out.println("handleException : " + ex.getMessage());

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(401);
        apiResponse.setResultValue("data",ex);
        apiResponse.setMessage("Test Exception : " + ex.getMessage());

        return apiResponse;
    }


}

