package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.DTO.RoomInfoDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.Repository.RoomInfoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomInfoService {

    private final RoomInfoRepository roomInfoRepository;


    // 전체 방 목록
    public ApiResponse getAllRoomList(LocalDateTime stDate, LocalDateTime enDate, int pageNo, int pagePerCnt) {
        ApiResponse apiResponse = new ApiResponse();

        if (pageNo < 0 || pagePerCnt < 1) {
            apiResponse.setCode(400);
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setMessage("페이지 구분이 정확하지않습니다.");
        } else {
            PageRequest pageRequest = PageRequest.of(pageNo, pagePerCnt, Sort.Direction.DESC, "updDate");

            Page<RoomInfo> rst = roomInfoRepository.findByUpdDateBetween(stDate, enDate, pageRequest);
            apiResponse.setCode(200);
            apiResponse.setResultValue("totCnt", rst.getTotalElements());
            apiResponse.setResultValue("totPage", rst.getTotalPages());
            apiResponse.setResultValue("roomInfo", rst.getContent());
            apiResponse.setMessage("생성된 방 리스트가 정삭적으로 조회되었습니다.");

        }
        return apiResponse;
    }

    // 나의 방 목록
    public ApiResponse getMyRoomList(int pageNo, int pagePerCnt) {

        ApiResponse apiResponse = new ApiResponse();
          AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          MemInfo memInfo = new MemInfo();
          memInfo.setMemNo(authUserDAO.getMemNo());
        if (pageNo < 0 || pagePerCnt < 1) {
            apiResponse.setCode(400);
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setMessage("페이지 구분이 정확하지않습니다.");
        } else {
            PageRequest pageRequest = PageRequest.of(pageNo, pagePerCnt, Sort.Direction.DESC, "updDate");

            Page<RoomInfo> rst = roomInfoRepository.findByHostMemNo(memInfo, pageRequest);
            apiResponse.setCode(200);
            apiResponse.setResultValue("totCnt", rst.getTotalElements());
            apiResponse.setResultValue("totPage", rst.getTotalPages());
            apiResponse.setResultValue("roomInfo", rst.getContent());
            apiResponse.setMessage("나의 방 리스트가 정삭적으로 조회되었습니다.");

        }
        return apiResponse;
    }

    // 방 생성
    public ApiResponse createRoomInfo(RoomInfoDTO roomInfoDto) {

        ApiResponse apiResponse = new ApiResponse();
        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        System.out.println(authUserDAO.getMemNo());
        MemInfo memInfo = new MemInfo();
        memInfo.setMemNo(authUserDAO.getMemNo());


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
