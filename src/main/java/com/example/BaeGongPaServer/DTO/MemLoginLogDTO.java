package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemLoginLogDTO {
    private final Long memNo;
    private final LocalDateTime insDate;

}
