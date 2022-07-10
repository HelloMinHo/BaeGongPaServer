package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MenuInfoDto implements Serializable {
    private final String menuName;
    private final String menuSub;
    private final BigDecimal menuPrice;
    private final MenuBoxInfoDto menuBoxNo;
    private final LocalDateTime insDate;
    private final LocalDateTime updDate;
}
