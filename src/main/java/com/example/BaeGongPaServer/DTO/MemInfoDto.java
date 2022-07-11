package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MemInfoDto implements Serializable {
    private final Integer id;
    private final String memId;
    private final String memPwd;
    private final String memNick;
    private final String memBgPhoto;
    private final String memPfPhoto;

}
