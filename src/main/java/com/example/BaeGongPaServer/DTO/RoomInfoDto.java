package com.example.BaeGongPaServer.DTO;

import com.example.BaeGongPaServer.Domain.MemInfo;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class RoomInfoDto implements Serializable {
    private final String roomName;
    private final String roomSub;
    private final Long hostMemNo;
    private final Integer areaLCode;
    private final Integer areaMCode;
    private final Integer areaSCode;
    private final String addrDetail;
    private final String inviteCode;



    
}
