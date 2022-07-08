package com.example.BaeGongPaServer.DomainId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomMemInfoId implements Serializable {

    private Long roomNo;
    private Long memNo;
}
