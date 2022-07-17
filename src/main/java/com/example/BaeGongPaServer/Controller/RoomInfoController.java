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

    @RequestMapping(value = "/room/myRoomList", method = RequestMethod.GET)
    public ApiResponse getMyRoomList() {

        return roomInfoService.getMyRoomList();

    }

    @RequestMapping(value = "/room/allRoomList", method = RequestMethod.GET)
    public ApiResponse getAllRoomList(@RequestParam Map<String, String> params) {

        LocalDateTime stDate = LocalDateTime.parse(params.get("stDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime enDate = LocalDateTime.parse(params.get("enDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return roomInfoService.getAllRoomList(stDate, enDate);

    }


}
