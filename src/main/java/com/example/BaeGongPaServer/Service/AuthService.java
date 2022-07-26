package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Auth.AuthProvider;
import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.MemInfoDAO;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.MemLoginLog;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
import com.example.BaeGongPaServer.Repository.MemLoginLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthProvider authProvider;
    private final MemInfoRepository memInfoRepository;
    private final MemLoginLogRepository memLoginLogRepository;


    @Transactional
    public ApiResponse memberLogin(AuthDTO authDTO) {
        MemInfo memInfo = memInfoRepository.findByMemIdAndMemPwd(authDTO.getMemId(), authDTO.getMemPwd());
        ApiResponse apiResponse = new ApiResponse();
        if (memInfo == null) {
            apiResponse.setCode(400);
            apiResponse.setMessage("이메일 또는 비밀번호를 확인해주세요.");
            apiResponse.setResultValue("Token", "");
        } else {
            MemLoginLog memLoginLog = new MemLoginLog();
            memLoginLog.setMemNo(memInfo.getMemNo());
            memLoginLog.setInsDate(LocalDateTime.now());
            memLoginLogRepository.save(memLoginLog);

            MemInfoDAO memInfoDAO = new MemInfoDAO();
            memInfoDAO.setMemId(memInfo.getMemId());
            memInfoDAO.setMemNo(memInfo.getMemNo());
            memInfoDAO.setMemNick(memInfo.getMemNick());
            memInfoDAO.setMemPfPhoto(memInfo.getMemBgPhoto());
            memInfoDAO.setMemRoll(memInfo.getMemRoll());
            memInfoDAO.setInsDate(memInfo.getInsDate());
            memInfoDAO.setUpdDate(memInfo.getUpdDate());

            apiResponse.setCode(200);
            apiResponse.setResultValue("AccessToken", authProvider.createAccessToken(authDTO));
            apiResponse.setResultValue("RefreshToken", authProvider.createRefreshToken(authDTO));
            apiResponse.setResultValue("memInfo", memInfoDAO);
            apiResponse.setMessage("성공적으로 로그인이 되었습니다.");
        }
        return apiResponse;
    }

    @Transactional
    public ApiResponse getAccessToken(String accessToken, String refreshToken) {
        ApiResponse apiResponse = new ApiResponse();

        if (accessToken != "" && refreshToken != "") {
            if (authProvider.validateJwtTokenExceptionExpire(accessToken)) {
                String authToken = authProvider.reCreateAccessToken(refreshToken);
                if (authToken.isEmpty()) {
                    apiResponse.setCode(400);
                    apiResponse.setMessage("새로운 로그인이 필요합니다.");
                } else {
                    apiResponse.setCode(200);
                    apiResponse.setResultValue("AccessToken", authToken);
                    apiResponse.setMessage("토큰이 재발급 되었습니다.");
                }
            } else {
                apiResponse.setCode(400);
                apiResponse.setMessage("만료되지 않은 토큰입니다.");
            }

        } else {
            apiResponse.setCode(401);
            apiResponse.setMessage("토큰정보가 올바르지않습니다.");
        }
        return apiResponse;
    }
}
