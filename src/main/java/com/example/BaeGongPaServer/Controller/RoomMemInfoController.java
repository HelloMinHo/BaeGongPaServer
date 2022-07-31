package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.Service.RoomInfoService;
import com.example.BaeGongPaServer.Service.RoomMemInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor

public class RoomMemInfoController {

    private final RoomMemInfoService roomMemInfoService;


    @RequestMapping(value = "/room/roomMemInfo", method = RequestMethod.GET)
    public ApiResponse getRoomInfo(@RequestBody Map<String, Object> params) {

        return roomMemInfoService.getRoomMemInfo(Long.parseLong(params.get("roomNo").toString()));
    }

    @RequestMapping(value = "/main/room-my", method = RequestMethod.GET)
    public ApiResponse getRoomInfo(int pageNo, int pagePerCnt) {

        return roomMemInfoService.getMyRoomList(pageNo,pagePerCnt);
    }


}
