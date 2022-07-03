package com.example.BaeGongPaServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {

    private String memId;
    private String memPwd;

    public AuthDTO(String memId, String memPwd) {
        this.memId = memId;
        this.memPwd = memPwd;
    }
}
