package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class MenuBoxInfoDto implements Serializable {
    private final Long id;
    private final String menuBoxName;
    private final String menuBoxSub;
    private final Integer menuCnt;
    private final RoomInfoDto roomNo;
    private final Instant insDate;
    private final Instant updDate;
}
