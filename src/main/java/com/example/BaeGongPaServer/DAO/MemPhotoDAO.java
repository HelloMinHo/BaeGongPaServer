package com.example.BaeGongPaServer.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MemPhotoDAO {


    private String photoType;
    private String photoPath;
    private String photoFile;
    private String photoSize;

    public MemPhotoDAO() {
    }
}
