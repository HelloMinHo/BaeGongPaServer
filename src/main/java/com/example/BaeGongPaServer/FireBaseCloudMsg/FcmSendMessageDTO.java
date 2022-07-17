package com.example.BaeGongPaServer.FireBaseCloudMsg;

import lombok.Data;

@Data
public class FcmSendMessageDTO {

    private Long memNo;
    private String title;
    private String body;
}
