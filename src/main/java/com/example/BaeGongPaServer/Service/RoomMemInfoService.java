package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.Domain.RoomMemInfo;
import com.example.BaeGongPaServer.Repository.RoomMemInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomMemInfoService {

    private final RoomMemInfoRepository roomMemInfoRepository;
    private ApiResponse apiResponse = new ApiResponse();

    public ApiResponse getRoomMemInfo(Long roomNo) {

//        RoomInfo roomInfo = new RoomInfo();
//        roomInfo.setId(roomNo);
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

    public ApiResponse createRoomMemInfo(RoomMemInfo roomMemInfo) {

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
