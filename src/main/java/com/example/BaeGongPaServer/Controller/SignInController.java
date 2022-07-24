package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.DTO.MemSessDTO;
import com.example.BaeGongPaServer.Service.AuthService;
import com.example.BaeGongPaServer.Service.MemPhotoService;
import com.example.BaeGongPaServer.Service.MemInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignInController {

    private final MemInfoService memInfoService;
    private final MemPhotoService memPhotoService;
    private final AuthService authService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ApiResponse memberLogin(@ModelAttribute AuthDTO authDTO) {
        return authService.memberLogin(authDTO);
    }

    @RequestMapping(value = "/signin/memsess", method = RequestMethod.POST)
    public ApiResponse insertMemSess(@ModelAttribute MemSessDTO memSessDTO) {

        return memInfoService.insertMemSess(memSessDTO);
    }


}
