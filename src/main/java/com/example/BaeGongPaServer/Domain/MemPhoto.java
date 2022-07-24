package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "mem_photo")
@DynamicInsert
@Data
public class MemPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_no")
    private Long PhotoNo;

    @Column(name = "photo_type")
    private String photoType;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "photo_size")
    private String photoSize;

    @Column(name = "photo_file")
    private String photoFile;

    @Column(name = "mem_no")
    private Long memNo;

    @Column(name = "ins_date")
    private LocalDateTime insDate;



}
