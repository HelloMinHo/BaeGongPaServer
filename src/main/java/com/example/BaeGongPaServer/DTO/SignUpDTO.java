package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignUpDTO implements Serializable {

    private final String memId;
    private final String memPwd;
    private final String memNick;
    private final String memPfPhoto;
    private final long memPfPhotoNo;

}
