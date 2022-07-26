package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.Service.AuthService;
import com.example.BaeGongPaServer.Service.MemPhotoService;
import com.example.BaeGongPaServer.Service.MemInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MemInfoController {

    private final AuthService authService;
    private final MemInfoService memInfoService;
    private final MemPhotoService memPhotoService;

    @RequestMapping(value = "/ref", method = RequestMethod.POST)
    public ApiResponse getAccessToken(@RequestHeader String AccessToken, @RequestHeader String RefreshToken) {

        System.out.println("AccessToken : " + AccessToken);
        System.out.println("RefreshToken : " + RefreshToken);

        return null;
    }

}
