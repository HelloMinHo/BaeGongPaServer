package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Auth.AuthProvider;
import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.MemLoginLog;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
import com.example.BaeGongPaServer.Repository.MemLoginLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthProvider authProvider;
    private final MemInfoRepository memInfoRepository;
    private final MemLoginLogRepository memLoginLogRepository;


    @Transactional
    public ApiResponse memberLogin(AuthDTO authDTO) {

        System.out.println(authDTO.getMemId() + " / " + authDTO.getMemPwd());
        MemInfo memInfo = memInfoRepository.findByMemIdAndMemPwd(authDTO.getMemId(), authDTO.getMemPwd());
        ApiResponse apiResponse = new ApiResponse();

        if (memInfo == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("로그인 실패");
            apiResponse.setResultValue("Token", null);
        } else {
            MemLoginLog memLoginLog = new MemLoginLog();
            memLoginLog.setMemNo(memInfo.getMemNo());
            memLoginLog.setInsDate(Instant.now());
            memLoginLogRepository.save(memLoginLog);

            apiResponse.setCode(200);
            apiResponse.setMessage("로그인 성공");
            apiResponse.setResultValue("Token", authProvider.createToken(authDTO));
        }

        return apiResponse;
    }


}
