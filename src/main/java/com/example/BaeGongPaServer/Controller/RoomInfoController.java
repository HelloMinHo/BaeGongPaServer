package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.RoomInfoDTO;
import com.example.BaeGongPaServer.Service.RoomInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RoomInfoController {

    private final RoomInfoService roomInfoService;
    private ApiResponse apiResponse = new ApiResponse();


    @RequestMapping(value = "/room/create", method = RequestMethod.POST)
    public ApiResponse createRoomInfo(@RequestBody RoomInfoDTO roomInfoDto) {

        System.out.println(roomInfoDto);
        return roomInfoService.createRoomInfo(roomInfoDto);
    }

//    @RequestMapping(value = "/room/myRoomList",method = RequestMethod.GET)
//    public ApiResponse getMyRoomList() {
//
//        return roomInfoService.getMyRoomList();
//    }

    @RequestMapping(value = "/main/room-host", method = RequestMethod.GET)
    public ApiResponse getMyRoomList(int pageNo, int pagePerCnt) {

        return roomInfoService.getMyRoomList(pageNo, pagePerCnt);
    }

    @RequestMapping(value = "/main/room-all", method = RequestMethod.GET)
    public ApiResponse getAllRoomList(int pageNo, int pagePerCnt) {
        // LocalDateTime.parse(stDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LocalDateTime.parse(enDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        LocalDateTime stDate = LocalDateTime.now().minusDays(1);
        LocalDateTime enDate = LocalDateTime.now();

        return roomInfoService.getAllRoomList(stDate, enDate, pageNo, pagePerCnt);


    }


}
