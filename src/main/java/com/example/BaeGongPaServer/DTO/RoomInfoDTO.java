package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomInfoDTO implements Serializable {
    private final String roomName;
    private final String roomSub;
    private final Long hostMemNo;
    private final Integer areaLCode;
    private final Integer areaMCode;
    private final Integer areaSCode;
    private final String addrDetail;
    private final String inviteCode;



    
}
