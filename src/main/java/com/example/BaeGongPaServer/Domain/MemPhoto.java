package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "mem_photo")
@DynamicInsert
@Data
public class MemPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_no", nullable = false)
    private Long PhotoNo;

    @Column(name = "photo_type", nullable = false)
    private String photoType;

    @Column(name = "photo_path", nullable = false)
    private String photoPath;

    @Column(name = "photo_size", nullable = false)
    private String photoSize;

    @Column(name = "photo_file", nullable = false)
    private String photoFile;

    @Column(name = "mem_no", nullable = false)
    private Long memNo;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

}
