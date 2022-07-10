package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MenuBoxInfoDto implements Serializable {
    private final Long id;
    private final String menuBoxName;
    private final String menuBoxSub;
    private final Integer menuCnt;
    private final RoomInfoDto roomNo;
    private final LocalDateTime insDate;
    private final LocalDateTime updDate;
}
