package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.Component.Result;
import com.example.BaeGongPaServer.DTO.RoomInfoDto;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.Service.RoomInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RoomInfoController {

    private final RoomInfoService roomInfoService;


    @RequestMapping(value = "/room/create", method = RequestMethod.POST)
    public ApiResponse createRoomInfo(@RequestBody RoomInfoDto roomInfoDto) {

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
    public ApiResponse getMyRoomList(@RequestBody Map<String, Object> params) {

        System.out.println(params.get("stDate"));
        System.out.println(params.get("enDate"));
        System.out.println(Instant.parse(params.get("stDate").toString()));

        //System.out.println(Instant.parse("stDate : " + params.get("stDate").toString()));
        //System.out.println(Instant.parse("enDate : " + params.get("enDate").toString()));
        Instant stDate = Instant.parse(params.get("stDate").toString());
        Instant enDate = Instant.parse(params.get("enDate").toString());
        //return roomInfoService.getAllRoomList(stDate, enDate);


        return roomInfoService.getAllRoomList(stDate,enDate);

    }


}
