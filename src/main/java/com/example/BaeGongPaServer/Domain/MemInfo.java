package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mem_info")
@DynamicInsert
@Data
public class MemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_no", nullable = false)
    private Long memNo;

    @Column(name = "mem_id", nullable = false)
    private String memId;

    @Column(name = "mem_pwd", nullable = false)
    private String memPwd;

    @Column(name = "mem_nick", nullable = false, length = 100)
    private String memNick;

    @Column(name = "mem_bg_photo", nullable = false)
    private String memBgPhoto;

    @Column(name = "mem_pf_photo", nullable = false)
    private String memPfPhoto;

    @Column(name = "mem_roll", nullable = false)
    private Integer memRoll;

    @Column(name = "auth_slct", nullable = false)
    private String authSlct;

    @Column(name = "auth_phone", nullable = false, length = 20)
    private String authPhone;

    @Column(name = "auth_name", nullable = false, length = 20)
    private String authName;

    @Column(name = "auth_date", nullable = false)
    private Instant authDate;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

}