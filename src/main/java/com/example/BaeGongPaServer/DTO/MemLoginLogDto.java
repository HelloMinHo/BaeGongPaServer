package com.example.BaeGongPaServer.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class MemLoginLogDto {
    private final Long memNo;
    private final Instant insDate;

}
