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
public class MemberInfoService {

    private final MemInfoRepository memInfoRepository;
    private final MemSessRepository memSessRepository;

    ApiResponse apiResponse = new ApiResponse();

    public ApiResponse createMemInfo(MemInfo memInfo) {

        if (memInfo.getMemId().replace(" ", "").isEmpty()) {
            apiResponse.setMessage("아이디를 입력해주세요.");
        } else if (memInfo.getMemPwd().replace(" ", "").isEmpty()) {
            apiResponse.setMessage("패스워드를 입력해주세요.");
        } else if (memInfo.getMemNick().replace(" ", "").isEmpty()) {
            apiResponse.setMessage("닉네임을 입력해주세요.");
        } else {
            MemInfo rst = memInfoRepository.save(memInfo);

            apiResponse.setCode(200);
            apiResponse.setResultValue("data", rst);
            apiResponse.setResultValue("data2", rst);
            apiResponse.setMessage("회원가입이 완료되었습니다.");
        }
        return apiResponse;
    }

    @Transactional
    public ApiResponse InsMemPfPhoto(String photoName) {

        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        MemInfo memInfo = memInfoRepository.findByMemId(authUserDAO.getMemId());
        memInfo.setMemPfPhoto(photoName);
        MemInfo rst = memInfoRepository.save(memInfo);

        if (rst == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("setMemPfPhoto 실패");
            apiResponse.setResultValue("data", "");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("setMemPfPhoto 성공");
            apiResponse.setResultValue("data", rst.getMemId() + " / " + rst.getMemNo());

        }
        return apiResponse;

    }

    @Transactional
    public ApiResponse updateFcmToken(String fcmToken) {
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
        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        MemSess memSess = new MemSess();

        memSess.setMemNo(memSessDTO.getMemNo());
        memSess.setDeviceId(memSessDTO.getDeviceId());
        memSess.setDeviceCode(memSessDTO.getDeviceCode());
        memSess.setFcmToken(memSessDTO.getFcmToken());
        memSess.setLatitude(memSessDTO.getLatitude());
        memSess.setLongitude(memSessDTO.getLongitude());
        memSess.setInsDate(LocalDateTime.now());
        memSess.setUpdDate(LocalDateTime.now());
        MemSess rst = memSessRepository.save(memSess);
        if (rst == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("insertMemSess 실패");
            apiResponse.setResultValue("data", "");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("insertMemSess 성공");
            apiResponse.setResultValue("data", rst);
        }
        return apiResponse;
    }


}
