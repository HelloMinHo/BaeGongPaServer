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

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthProvider authProvider;
    private final MemInfoRepository memInfoRepository;
    private final MemLoginLogRepository memLoginLogRepository;

    ApiResponse apiResponse = new ApiResponse();

    @Transactional
    public ApiResponse memberLogin(AuthDTO authDTO) {
        MemInfo memInfo = memInfoRepository.findByMemIdAndMemPwd(authDTO.getMemId(), authDTO.getMemPwd());

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
            apiResponse.setResultValue("Token", authProvider.createAccessToken(authDTO));
            apiResponse.setResultValue("memInfo", memInfoDAO);
            apiResponse.setMessage("성공적으로 로그인이 되었습니다.");
        }

        return apiResponse;
    }

}
