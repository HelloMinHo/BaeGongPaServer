package com.example.BaeGongPaServer.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MemInfoDAO {

    private long memNo;
    private String memId;
    private String memNick;
    private String memPfPhoto;
    private LocalDateTime insDate;
    private LocalDateTime updDate;
    private int memRoll;

    public MemInfoDAO() {
    }
}
