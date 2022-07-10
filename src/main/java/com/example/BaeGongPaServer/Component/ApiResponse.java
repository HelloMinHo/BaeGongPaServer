package com.example.BaeGongPaServer.Component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiResponse {

    public ApiResponse() {
    }

    private int code = HttpStatus.OK.value();
    private Map result = new HashMap();
    private String message;

    public void setResultValue(String key, Object value) {
        this.result.put(key, value);
    }


}
