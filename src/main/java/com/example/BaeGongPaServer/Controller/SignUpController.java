package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;

import com.example.BaeGongPaServer.DAO.MemPhotoDAO;
import com.example.BaeGongPaServer.DTO.MemPhotoDTO;

import com.example.BaeGongPaServer.DTO.SignUpDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;

import com.example.BaeGongPaServer.Service.MemPhotoService;
import com.example.BaeGongPaServer.Service.MemInfoService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final MemInfoService memInfoService;
    private final MemPhotoService memPhotoService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ApiResponse memInfoIns(@ModelAttribute SignUpDTO signUpDTO) {

        MemInfo memInfo = new MemInfo();
        memInfo.setMemId(signUpDTO.getMemId());
        memInfo.setMemPwd(signUpDTO.getMemPwd());
        memInfo.setMemNick(signUpDTO.getMemNick());
        memInfo.setMemPfPhoto(signUpDTO.getMemPfPhoto());
        memInfo.setMemPfPhotoNo(signUpDTO.getMemPfPhotoNo());
        memInfo.setInsDate(LocalDateTime.now());
        memInfo.setUpdDate(LocalDateTime.now());

        return memInfoService.createMemInfo(memInfo);
    }

    @RequestMapping(value = "/signup-chk/id", method = RequestMethod.POST)
    public ApiResponse memInfoCheckMemId(@RequestParam String memId) {

        boolean rst = memInfoService.memIdCheck(memId);
        ApiResponse apiResponse = new ApiResponse();
        if (rst) {
            apiResponse.setCode(400);
            apiResponse.setMessage("이미 사용중인 이메일 입니다.");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("사용 가능한 이메일 입니다.");
        }
        return apiResponse;
    }

    @RequestMapping(value = "/signup-chk/nick", method = RequestMethod.POST)
    public ApiResponse memInfoCheckMemNick(@RequestParam String memNick) {
        boolean rst = memInfoService.memNickCheck(memNick);
        ApiResponse apiResponse = new ApiResponse();
        if (rst) {
            apiResponse.setCode(400);
            apiResponse.setMessage("이미 사용중인 닉네임 입니다.");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("사용 가능한 닉네임 입니다.");
        }
        return apiResponse;
    }


    @RequestMapping(value = "/signup/photo", method = RequestMethod.POST)
    public ApiResponse photoFileIns(@RequestParam MultipartFile file) throws IOException {
        return memPhotoService.savePhotofile(file);
    }

//    @RequestMapping(value = "/signup/memphoto", method = RequestMethod.POST)
//    public ApiResponse prfilePhotoIns(@ModelAttribute MemPhotoDTO memPhotoDTO) {
//
//
//        return memPhotoService.insertMemPhoto(memPhotoDTO);
//    }


}
