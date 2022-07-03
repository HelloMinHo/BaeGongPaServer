package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.MemInfoDto;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class MemberInfoService {

    private final MemInfoRepository memInfoRepository;

    public MemberInfoService(MemInfoRepository memInfoRepository) {
        this.memInfoRepository = memInfoRepository;
    }

    public ApiResponse createMemInfo(MemInfoDto memInfoDto) {
        ApiResponse apiResponse = new ApiResponse();
        MemInfo memInfo = new MemInfo();
        memInfo.setMemId(memInfoDto.getMemId());
        memInfo.setMemNick(memInfoDto.getMemNick());
        memInfo.setMemPwd(memInfoDto.getMemPwd());
        memInfo.setMemBgPhoto(memInfoDto.getMemBgPhoto());
        memInfo.setMemPfPhoto(memInfoDto.getMemPfPhoto());
        memInfo.setMemRoll(0);
        memInfo.setAuthDate(Instant.now());
        memInfo.setInsDate(Instant.now());
        memInfo.setUpdDate(Instant.now());

        //
        memInfo.setAuthName("");
        memInfo.setAuthPhone("");
        memInfo.setAuthSlct("");



        MemInfo rst = memInfoRepository.save(memInfo);

        if (rst == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("회원가입 실패");
            apiResponse.setResultValue("data", "");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("회원가입 성공");
            apiResponse.setResultValue("data", rst.getMemId() + " / " + rst.getMemNo());

        }

        return apiResponse;


    }
}
