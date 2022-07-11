package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.DTO.MemInfoDto;
import com.example.BaeGongPaServer.DTO.MemPhotoDto;
import com.example.BaeGongPaServer.Service.AuthService;
import com.example.BaeGongPaServer.Service.MemPhotoService;
import com.example.BaeGongPaServer.Service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
                String filePath = System.getProperty("user.dir") + "/Assets/photo/";
                String fileName = uuid + "." + fileType;
                String fileSize = file.getSize() + "";

                System.out.println("filePath + fileName : " + filePath + fileName);
                file.transferTo(new File(filePath + fileName));
                memInfoService.InsMemPfPhoto(filePath + fileName);
                MemPhotoDto memPhotoDto = new MemPhotoDto("a", filePath, fileName, fileSize, 0l);
                apiResponse = memPhotoService.InsMemPhoto(memPhotoDto);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {

        }

        return apiResponse;
    }
//
//
//    // 회원가입
//    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
//    public ApiResponse signIn(@ModelAttribute MemInfoDto memInfoDto) {
//
//        ApiResponse apiResponse = memInfoService.createMemInfo(memInfoDto);
//        System.out.println("apiResponse" + apiResponse);
//
//        return apiResponse;
//    }

}
