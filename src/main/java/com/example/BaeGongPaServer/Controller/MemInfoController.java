package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.MemPhotoDTO;
import com.example.BaeGongPaServer.DTO.MemSessDTO;
import com.example.BaeGongPaServer.Service.AuthService;
import com.example.BaeGongPaServer.Service.MemPhotoService;
import com.example.BaeGongPaServer.Service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class MemInfoController {

    private final AuthService authService;
    private final MemberInfoService memInfoService;
    private final MemPhotoService memPhotoService;
//
//
//    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
//    public ApiResponse signUp(@RequestBody AuthDTO authDTO) {
//        ApiResponse apiResponse = authService.memberLogin(authDTO);
//
//
//
//        System.out.println("apiResponse : " + apiResponse);
//
//        return apiResponse;
//    }
//

    @RequestMapping(value = "/photoFile", method = RequestMethod.POST)
    public ApiResponse regPhoto(@RequestParam MultipartFile file) {

        ApiResponse apiResponse = new ApiResponse();
        UUID uuid = UUID.randomUUID();
        try {
            String fileType = file.getContentType().substring(file.getContentType().indexOf("/") + 1);

            if ("png|jpg|jpeg|".contains(fileType)) {

                String filePath = "img/";
                String fileName = uuid + "." + fileType;
                String fileSize = file.getSize() + "";

                file.transferTo(new File(filePath + fileName));
                memInfoService.InsMemPfPhoto(filePath + fileName);
                MemPhotoDTO memPhotoDto = new MemPhotoDTO("a", filePath, fileName, fileSize, 0l);
                apiResponse = memPhotoService.InsMemPhoto(memPhotoDto);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return apiResponse;
    }

    @RequestMapping(value = "/reg-fcm", method = RequestMethod.POST)
    public ApiResponse updateFcmToken(@RequestParam String fcmToken) {

        ApiResponse apiResponse = new ApiResponse();
        apiResponse = memInfoService.updateFcmToken(fcmToken);

        return apiResponse;
    }

    @RequestMapping(value = "/ins-sess", method = RequestMethod.POST)
    public ApiResponse insertMemSess(@RequestParam MemSessDTO memSessDTO) {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse = memInfoService.insertMemSess(memSessDTO);

        return apiResponse;
    }



}
