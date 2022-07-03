package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Auth.AuthProvider;
import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

=======
import org.springframework.stereotype.Service;

>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
@Service
public class AuthService {
    private final AuthProvider authProvider;
    private final MemInfoRepository memInfoRepository;

    public AuthService(AuthProvider authProvider, MemInfoRepository memInfoRepository) {
        this.authProvider = authProvider;
        this.memInfoRepository = memInfoRepository;
    }


    public ApiResponse memberLogin(AuthDTO authDTO) {

        MemInfo memInfo = memInfoRepository.findByMemIdAndMemPwd(authDTO.getMemId(), authDTO.getMemPwd());

        ApiResponse apiResponse = new ApiResponse();

        if (memInfo == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("로그인 실패");
            apiResponse.setResultValue("Token", "");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("로그인 성공");
<<<<<<< HEAD
            apiResponse.setResultValue("Token", authProvider.createToken(authDTO.getMemId()));
=======
            apiResponse.setResultValue("Token", authProvider.createToken(authDTO));
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
        }

        return apiResponse;


    }
}
