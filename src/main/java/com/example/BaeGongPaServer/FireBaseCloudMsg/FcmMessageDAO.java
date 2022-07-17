package com.example.BaeGongPaServer.FireBaseCloudMsg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.aspectj.bridge.Message;

import javax.management.Notification;

@Builder
@Getter
@AllArgsConstructor
public class FcmMessageDAO {
    private boolean validate_only;
    private Message message;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Message {
        private Notification notification;
        private String token;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Notification {
        private String title;
        private String body;
        private String image;
    }

}
