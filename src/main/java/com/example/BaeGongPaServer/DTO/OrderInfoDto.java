package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class OrderInfoDto implements Serializable {
    private final String orderName;
    private final String orderSub;
    private final RoomInfoDto roomNo;
    private final Integer orderMemNo;
    private final Instant orderAbleDate;
    private final Instant orderRcvDate;
    private final String prePayYn;
    private final String menuBoxYn;
    private final Long menuBoxNo;
    private final String orderEndYn;
    private final Instant orderEndDate;
    private final Instant insDate;
    private final Instant updDate;
}
