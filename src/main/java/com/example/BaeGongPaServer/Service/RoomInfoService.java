package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.DTO.RoomInfoDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.Repository.RoomInfoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomInfoService {

    private final RoomInfoRepository roomInfoRepository;
    private ApiResponse apiResponse = new ApiResponse();

    // 전체 방 목록
    public ApiResponse getAllRoomList(LocalDateTime stDate, LocalDateTime enDate) {
        List<RoomInfo> rst = roomInfoRepository.findByInsDateBetween(stDate, enDate);
        if (rst.size() > 0) {
            apiResponse.setResultValue("data", rst);
            apiResponse.setMessage("방 리스트 성공");
        } else {
            apiResponse.setCode(401);
            apiResponse.setResultValue("data", rst);
            apiResponse.setMessage("방 리스트 실패");
        }
        return apiResponse;
    }

    // 나의 방 목록
    public ApiResponse getMyRoomList() {

        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MemInfo memInfo = new MemInfo();
        memInfo.setMemNo(authUserDAO.getMemNo());
        List<RoomInfo> rst = roomInfoRepository.findByHostMemNo(memInfo);

        if (rst.size() > 0) {
            apiResponse.setResultValue("data", rst);
            apiResponse.setMessage("방 호출 성공");
        } else {
            apiResponse.setCode(401);
            apiResponse.setResultValue("data", rst);
            apiResponse.setMessage("방 호출 실패");
        }
        return apiResponse;
    }

    // 방 생성
    public ApiResponse createRoomInfo(RoomInfoDTO roomInfoDto) {


        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        System.out.println(authUserDAO.getMemNo());
        MemInfo memInfo = new MemInfo();
        memInfo.setMemNo(authUserDAO.getMemNo());

        ApiResponse apiResponse = new ApiResponse();
        RoomInfo roomInfo = new RoomInfo(
                roomInfoDto.getRoomName()
                , roomInfoDto.getRoomSub()
                , roomInfoDto.getAreaLCode()
                , roomInfoDto.getAreaMCode()
                , roomInfoDto.getAreaSCode()
                , roomInfoDto.getAddrDetail()
                , memInfo
                , 0l
                , roomInfoDto.getInviteCode()
                , LocalDateTime.now()
                , LocalDateTime.now()
        );

        RoomInfo rst = roomInfoRepository.save(roomInfo);

        if (rst == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("방 생성 실패");
            apiResponse.setResultValue("data", "");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("방 생성 성공");
            apiResponse.setResultValue("data", rst.getId() + " / " + rst.getRoomName());

        }
        return apiResponse;
    }


}
