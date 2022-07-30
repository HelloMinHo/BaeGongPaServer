package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.DTO.MemSessDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;

import com.example.BaeGongPaServer.Domain.MemSess;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;

import com.example.BaeGongPaServer.Repository.MemSessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class MemInfoService {

    private final MemInfoRepository memInfoRepository;
    private final MemSessRepository memSessRepository;

    public ApiResponse memIdCheck(String memId) {
        ApiResponse apiResponse = new ApiResponse();
        boolean rst = memInfoRepository.existsByMemId(memId);
        if (rst) {
            apiResponse.setCode(400);
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setMessage("이미 사용중인 이메일 입니다.");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("사용 가능한 이메일 입니다.");
        }

        return apiResponse;
    }

    public ApiResponse memNickCheck(String memNick) {
        ApiResponse apiResponse = new ApiResponse();
        boolean rst = memInfoRepository.existsByMemNick(memNick);
        if (rst) {
            apiResponse.setCode(400);
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setMessage("이미 사용중인 닉네임 입니다.");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("사용 가능한 닉네임 입니다.");
        }

        return apiResponse;
    }


    public ApiResponse createMemInfo(MemInfo memInfo) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResultValue("memNo", 0);

        if (memInfoRepository.existsByMemId(memInfo.getMemId())) {
            apiResponse.setMessage("이미 가입된 이메일 입니다.");
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setCode(400);
        } else if (memInfoRepository.existsByMemNick(memInfo.getMemNick().trim())) {
            apiResponse.setMessage("이미 가입된 닉네임 입니다.");
            apiResponse.setResultValue("RESULT_CODE", -2);
            apiResponse.setCode(400);
        } else if (memInfo.getMemId().trim().isEmpty()) {
            apiResponse.setMessage("아이디를 입력해주세요.");
            apiResponse.setResultValue("RESULT_CODE", -3);
            apiResponse.setCode(400);
        } else if (memInfo.getMemPwd().trim().isEmpty()) {
            apiResponse.setMessage("패스워드를 입력해주세요.");
            apiResponse.setResultValue("RESULT_CODE", -4);
            apiResponse.setCode(400);
        } else if (memInfo.getMemNick().trim().isEmpty()) {
            apiResponse.setMessage("닉네임을 입력해주세요.");
            apiResponse.setResultValue("RESULT_CODE", -5);
            apiResponse.setCode(400);
        } else {
            apiResponse.setCode(200);
            MemInfo rst = memInfoRepository.save(memInfo);
            apiResponse.setResultValue("memNo", rst.getMemNo());
            apiResponse.setMessage("회원가입이 완료되었습니다.");
        }

        return apiResponse;
    }

    @Transactional
    public ApiResponse updateFcmToken(String fcmToken) {
        ApiResponse apiResponse = new ApiResponse();
        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        memSessRepository.updateFcmTokenByMemNo(authUserDAO.getMemNo(), fcmToken);
        int res = 1;
        if (res < 1) {
            apiResponse.setCode(401);
            apiResponse.setMessage("updateFcmToken 실패");
            apiResponse.setResultValue("data", "");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("updateFcmToken 성공");
            apiResponse.setResultValue("data", res);


        }
        return apiResponse;
    }

    @Transactional
    public ApiResponse insertMemSess(MemSessDTO memSessDTO) {
        ApiResponse apiResponse = new ApiResponse();
        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        MemSess memSess = new MemSess();

        memSess.setMemNo(authUserDAO.getMemNo());
        memSess.setDeviceId(memSessDTO.getDeviceId());
        memSess.setDeviceCode(memSessDTO.getDeviceCode());
        memSess.setFcmToken(memSessDTO.getFcmToken());
        memSess.setLatitude(memSessDTO.getLatitude());
        memSess.setLongitude(memSessDTO.getLongitude());
        memSess.setInsDate(LocalDateTime.now());
        memSess.setUpdDate(LocalDateTime.now());
        MemSess rst = memSessRepository.save(memSess);
        if (rst == null) {
            apiResponse.setCode(400);
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setMessage("세션정보 등록에 실패하였습니다.");
        } else {
            apiResponse.setCode(200);
            apiResponse.setResultValue("memNo", rst.getMemNo());
            apiResponse.setMessage("회원의 세션정보가 등록되었습니다.");
        }
        return apiResponse;
    }


}
