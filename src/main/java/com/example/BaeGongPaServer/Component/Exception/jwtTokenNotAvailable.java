package com.example.BaeGongPaServer.Component.Exception;

public class jwtTokenNotAvailable extends RuntimeException {
    private final String message;

    public jwtTokenNotAvailable(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
