package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemInfoDTO implements Serializable {
    private final Integer id;
    private final String memId;
    private final String memPwd;
    private final String memNick;
    private final String memBgPhoto;
    private final String memPfPhoto;

}
