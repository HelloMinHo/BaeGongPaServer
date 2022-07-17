package com.example.BaeGongPaServer.FireBaseCloudMsg;

import lombok.Data;

@Data
public class FcmDeviceTokenDTO {

    private String targetToken;
    private String title;
    private String body;


}
