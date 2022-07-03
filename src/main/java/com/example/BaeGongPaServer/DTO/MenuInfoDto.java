package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class MenuInfoDto implements Serializable {
    private final String menuName;
    private final String menuSub;
    private final BigDecimal menuPrice;
    private final MenuBoxInfoDto menuBoxNo;
    private final Instant insDate;
    private final Instant updDate;
}
