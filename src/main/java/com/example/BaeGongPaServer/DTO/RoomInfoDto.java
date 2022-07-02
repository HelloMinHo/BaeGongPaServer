package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class RoomInfoDto implements Serializable {
    private final String roomName;
    private final String roomSub;
    private final Integer areaLCode;
    private final Integer areaMCode;
    private final Integer areaSCode;
    private final String addrDetail;
    private final MemInfoDto hostMemNo;
    private final Integer subMemNo;
    private final String inviteCode;
    private final Instant insDate;
    private final Instant updDate;

    
}
