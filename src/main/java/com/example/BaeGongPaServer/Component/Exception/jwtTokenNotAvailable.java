package com.example.BaeGongPaServer.Component.Exception;

public class jwtTokenNotAvailable extends RuntimeException {
    private final String message;
    private final int rstNo;

    public jwtTokenNotAvailable(String message, int rstNo) {
        this.message = message;
        this.rstNo = rstNo;
    }

    public String getMessage() {
        return this.message;
    }

    public int getRstNo() {
        return this.rstNo;
    }
}
