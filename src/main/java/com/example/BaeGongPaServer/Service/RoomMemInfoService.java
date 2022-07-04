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

    public ApiResponse getRoomMemInfo(Long roomNo) {

//        RoomInfo roomInfo = new RoomInfo();
//        roomInfo.setId(roomNo);
        List<RoomMemInfo> rst = roomMemInfoRepository.findByRoomNo(roomNo);

        if (rst == null) {
            System.out.println("RoomMemInfo IS NULL");

            return new ApiResponse(401, null, "방 호출 실패");
        } else {
            System.out.println("RoomMemInfo : " + rst);
            System.out.println("roomNo : " + roomNo);
            return new ApiResponse(200, rst, "방 호출 성공");
        }
    }

}
