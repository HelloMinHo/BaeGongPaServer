package com.example.BaeGongPaServer.FireBaseCloudMsg;

import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
import com.example.BaeGongPaServer.Repository.MemSessRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.apache.http.HttpHeaders;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FcmService {

    private final MemInfoRepository memInfoRepository;
    private final MemSessRepository memSessRepository;

    private final String API_URL = "https://fcm.googleapis.com/v1/projects/baegongpa/messages:send";
    private final ObjectMapper objectMapper;

    public String getAccessToken() throws IOException {

        String accessToken;
        ClassPathResource resource = new ClassPathResource("fcmmsg.json");
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(resource.getInputStream()).createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));

        googleCredentials.refreshIfExpired();
        accessToken = googleCredentials.getAccessToken().getTokenValue();
        System.out.println("FCM accessToken : " + accessToken);
        return accessToken;
    }

    public String getTargetToken(Long memNo) {

        return memSessRepository.findByMemNo(memNo).getFcmToken();
    }

    public void sendMessageTo(Long memNo, String title, String body) throws IOException {
        String message = makeMessage(getTargetToken(memNo), title, body);
        System.out.println("message : " + message);

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(message, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .post(requestBody)
                .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.body().string());



    }

    private String makeMessage(String targetToken, String title, String body) throws JsonProcessingException {

        FcmMessageDAO fcmMessageDAO = FcmMessageDAO.builder()

                .message(FcmMessageDAO.Message.builder()
                        .token(targetToken)
                        .notification(FcmMessageDAO.Notification.builder()
                                .title(title)
                                .body(body).image(null).build()
                        )
                        .build()
                ).validate_only(false)
                .build();

        return objectMapper.writeValueAsString(fcmMessageDAO);

    }
}
