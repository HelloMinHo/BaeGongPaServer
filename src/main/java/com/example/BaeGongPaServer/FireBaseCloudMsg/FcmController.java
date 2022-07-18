package com.example.BaeGongPaServer.FireBaseCloudMsg;

import com.example.BaeGongPaServer.Component.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FcmController {

    private final FcmService fcmService;

    @RequestMapping(value = "/getAccessToken", method = RequestMethod.POST)
    private ApiResponse getAccessToken() throws IOException {

        fcmService.getAccessToken();
        return null;

    }

    @RequestMapping(value = "/sendFcm", method = RequestMethod.POST)
    private String sendFcmMessage(@ModelAttribute FcmSendMessageDTO FcmSendMessageDTO) throws IOException {

        return fcmService.sendMessageTo(FcmSendMessageDTO.getMemNo(), FcmSendMessageDTO.getTitle(), FcmSendMessageDTO.getBody());


    }
}
