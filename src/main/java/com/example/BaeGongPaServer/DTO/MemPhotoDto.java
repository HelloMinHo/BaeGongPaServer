package com.example.BaeGongPaServer.DTO;

import com.example.BaeGongPaServer.Domain.MemInfo;
import lombok.Data;

@Data
public class MemPhotoDto {
    private final String photoType;
    private final String photoPath;
    private final String photoFile;
    private final String photoSize;
    private final Long memNo;

}
