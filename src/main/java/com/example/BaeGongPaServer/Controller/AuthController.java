package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.DTO.MemInfoDTO;
import com.example.BaeGongPaServer.DTO.MemPhotoDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Service.AuthService;
import com.example.BaeGongPaServer.Service.MemPhotoService;
import com.example.BaeGongPaServer.Service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MemberInfoService memInfoService;
    private final MemPhotoService memPhotoService;


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ApiResponse signUp(@ModelAttribute AuthDTO authDTO) {
        ApiResponse apiResponse = authService.memberLogin(authDTO);
        System.out.println("로그인 성공");
        return apiResponse;
    }


    @RequestMapping(value = "/signUp/photo", method = RequestMethod.POST)
    public ApiResponse regPhoto(@ModelAttribute MemPhotoDTO memPhotoDto) {

        ApiResponse apiResponse = memPhotoService.InsMemPhoto(memPhotoDto);

        memInfoService.InsMemPfPhoto(memPhotoDto.getPhotoPath() + memPhotoDto.getPhotoFile());
        System.out.println("apiResponse" + apiResponse);

        return apiResponse;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ApiResponse signIn(@ModelAttribute MemInfoDTO memInfoDto) {

        MemInfo memInfo = new MemInfo();
        memInfo.setMemId(memInfoDto.getMemId());
        memInfo.setMemNick(memInfoDto.getMemNick());
        memInfo.setMemPwd(memInfoDto.getMemPwd());
        memInfo.setInsDate(LocalDateTime.now());
        memInfo.setUpdDate(LocalDateTime.now());

        return memInfoService.createMemInfo(memInfo);
    }

    @RequestMapping(value = "/user/roomList", method = RequestMethod.POST)
    public ApiResponse userRoomList(@AuthenticationPrincipal UserDetails userDetails, @RequestParam HashMap<String, String> params) {

        System.out.println("getUsername : " + userDetails.getUsername());
        System.out.println("getPassword : " + userDetails.getPassword());
//        ApiResponse apiResponse = memInfoService.createMemInfo(memInfoDTO);
        System.out.println("params : " + params);


        return null;
    }

    @RequestMapping(value = "/roomList", method = RequestMethod.POST)
    public ApiResponse allRoomList(@AuthenticationPrincipal UserDetails userDetails, @RequestParam HashMap<String, String> params) {

        System.out.println("getUsername : " + userDetails.getUsername());
        System.out.println("getPassword : " + userDetails.getPassword());
//        ApiResponse apiResponse = memInfoService.createMemInfo(memInfoDTO);


        return null;
    }
}
