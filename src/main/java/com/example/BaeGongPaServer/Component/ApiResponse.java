package com.example.BaeGongPaServer.Component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiResponse {

    public ApiResponse()  {
    }

    private int code = HttpStatus.OK.value();
    private Object result;
    private String message;

    public void setResultValue(String key, Object value) {
        Map responseData = new HashMap<>();
        responseData.put(key, value);
        this.result = responseData;
    }

    public ApiResponse(int code, Object result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }


}
