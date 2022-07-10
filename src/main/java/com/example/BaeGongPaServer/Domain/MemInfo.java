package com.example.BaeGongPaServer.Domain;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mem_info")
@DynamicInsert
@DynamicUpdate
@Data
public class MemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_no")
    private Long memNo;

    @Column(name = "mem_id")
    private String memId;

    @Column(name = "mem_pwd")
    private String memPwd;

    @Column(name = "mem_nick", length = 100)
    private String memNick;

    @Column(name = "mem_bg_photo")
    private String memBgPhoto;

    @Column(name = "mem_pf_photo")
    private String memPfPhoto;

    @Column(name = "mem_roll")
    private Integer memRoll;

    @Column(name = "auth_slct")
    private String authSlct;

    @Column(name = "auth_phone", length = 20)
    private String authPhone;

    @Column(name = "auth_name", length = 20)
    private String authName;

    @Column(name = "auth_date")
    private LocalDateTime authDate;

    @Column(name = "ins_date")
    private LocalDateTime insDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;


    public MemInfo() {
    }
}