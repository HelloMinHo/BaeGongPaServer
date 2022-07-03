package com.example.BaeGongPaServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {

    private String memId;
    private String memPwd;

    public AuthDTO(String memEmail, String memPwd) {
        this.memId = memEmail;
        this.memPwd = memPwd;
    }
}
