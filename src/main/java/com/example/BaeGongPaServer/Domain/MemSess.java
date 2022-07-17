package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mem_sess")
@DynamicInsert
@DynamicUpdate
@Data
public class MemSess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_no")
    private Long memNo;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "device_code")
    private String deviceCode;

    @Column(name = "fcm_token")
    private String fcmToken;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "ins_date")
    private LocalDateTime insDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;

}
