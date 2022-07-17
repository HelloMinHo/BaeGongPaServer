package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OrderInfoDTO implements Serializable {
    private final String orderName;
    private final String orderSub;
    private final RoomInfoDTO roomNo;
    private final Integer orderMemNo;
    private final LocalDateTime orderAbleDate;
    private final LocalDateTime orderRcvDate;
    private final String prePayYn;
    private final String menuBoxYn;
    private final Long menuBoxNo;
    private final String orderEndYn;
    private final LocalDateTime orderEndDate;
    private final LocalDateTime insDate;
    private final LocalDateTime updDate;
}
