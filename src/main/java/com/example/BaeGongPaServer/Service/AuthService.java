package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Auth.AuthProvider;
import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthProvider authProvider;
    private final MemInfoRepository memInfoRepository;

    public AuthService(AuthProvider authProvider, MemInfoRepository memInfoRepository) {
        this.authProvider = authProvider;
        this.memInfoRepository = memInfoRepository;
    }


    public ApiResponse memberLogin(AuthDTO authDTO) {

        System.out.println(authDTO.getMemId()+ " / " +  authDTO.getMemPwd());
        MemInfo memInfo = memInfoRepository.findByMemIdAndMemPwd(authDTO.getMemId(), authDTO.getMemPwd());

        ApiResponse apiResponse = new ApiResponse();

        if (memInfo == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("로그인 실패");
            apiResponse.setResultValue("Token",null );
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("로그인 성공");
            apiResponse.setResultValue("Token", authProvider.createToken(authDTO));
        }

        return apiResponse;


    }
}
