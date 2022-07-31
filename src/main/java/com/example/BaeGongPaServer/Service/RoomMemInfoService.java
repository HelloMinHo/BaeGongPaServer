package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.Domain.RoomMemInfo;
import com.example.BaeGongPaServer.Repository.RoomMemInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomMemInfoService {

    private final RoomMemInfoRepository roomMemInfoRepository;


    @Transactional
    public ApiResponse getRoomMemInfo(Long roomNo) {

//        RoomInfo roomInfo = new RoomInfo();
//        roomInfo.setId(roomNo);
        ApiResponse apiResponse = new ApiResponse();
        List<RoomMemInfo> rst = roomMemInfoRepository.findByRoomNo(roomNo);

        if (rst.size() > 0) {
            apiResponse.setResultValue("data", rst);
            apiResponse.setMessage("방 호출 성공");

        } else {
            apiResponse.setCode(401);
            apiResponse.setResultValue("data", rst);
            apiResponse.setMessage("방 호출 성공");
        }
        return apiResponse;
    }

    @Transactional
    public ApiResponse getMyRoomList(int pageNo, int pagePerCnt) {
        ApiResponse apiResponse = new ApiResponse();


        if (pageNo < 0 || pagePerCnt < 1) {
            apiResponse.setCode(400);
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setMessage("페이지 구분이 정확하지않습니다.");
        } else {
            AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            PageRequest pageRequest = PageRequest.of(pageNo, pagePerCnt, Sort.Direction.DESC, "updDate");

            MemInfo memInfo = new MemInfo();
            memInfo.setMemNo(authUserDAO.getMemNo());
            Page<RoomMemInfo> rst = roomMemInfoRepository.findByMemNo(memInfo, pageRequest);

            apiResponse.setCode(200);
            apiResponse.setResultValue("totCnt", rst.getTotalElements());
            apiResponse.setResultValue("totPage", rst.getTotalPages());
            apiResponse.setResultValue("roomInfo", rst.getContent());
            apiResponse.setMessage("참여중인 방 리스트 조회가 완료되었습니다.");
        }
        return apiResponse;
    }


    public ApiResponse createRoomMemInfo(RoomMemInfo roomMemInfo) {
        ApiResponse apiResponse = new ApiResponse();
        RoomMemInfo rst = roomMemInfoRepository.save(roomMemInfo);
        if (rst != null) {
            apiResponse.setResultValue("data", rst);
            apiResponse.setMessage("방 호출 성공");

        } else {
            apiResponse.setCode(401);
            apiResponse.setResultValue("data", null);
            apiResponse.setMessage("방 호출 성공");
        }
        return apiResponse;
    }

}
