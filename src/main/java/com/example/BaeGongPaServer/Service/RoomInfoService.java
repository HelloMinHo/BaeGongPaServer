package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.Component.Result;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.DTO.RoomInfoDto;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.Repository.RoomInfoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomInfoService {

    private final RoomInfoRepository roomInfoRepository;

    public ApiResponse getAllRoomList(Instant stDate, Instant enDate) {

        List<RoomInfo> rst = roomInfoRepository.findByInsDateBetween(stDate, enDate);

        if (rst.size() == 0) {
            System.out.println("RoomList IS NULL");

            return new ApiResponse(401, null, "방 호출 실패");
        } else {
            System.out.println("RoomList : " + rst);
            System.out.println("HostMemNo : " + rst.get(0).getHostMemNo().getMemNo());
            return new ApiResponse(200, rst, "방 호출 성공");
        }
    }

    public ApiResponse getMyRoomList() {

        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MemInfo memInfo = new MemInfo();
        memInfo.setMemNo(authUserDAO.getMemNo());
        List<RoomInfo> rst = roomInfoRepository.findByHostMemNo(memInfo);

        if (rst.size() == 0) {
            System.out.println("RoomList IS NULL");

            return new ApiResponse(401, null, "방 호출 실패");
        } else {
            System.out.println("RoomList : " + rst);
            System.out.println("HostMemNo : " + rst.get(0).getHostMemNo().getMemNo());
            return new ApiResponse(200, rst, "방 호출 성공");
        }
    }

    public ApiResponse createRoomInfo(RoomInfoDto roomInfoDto) {


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
                , Instant.now()
                , Instant.now()
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
