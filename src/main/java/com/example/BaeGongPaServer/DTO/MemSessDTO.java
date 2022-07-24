package com.example.BaeGongPaServer.DTO;

import lombok.Data;

@Data
public class MemSessDTO {

    private String deviceId;
    private String deviceCode;
    private String fcmToken;
    private String latitude;
    private String longitude;

}
